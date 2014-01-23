public class Set {
	private class Item {
		public String value;
		public Item next;
		public Item(String value, Item next) {
			this.value = value;
			this.next = next;
		}
	}
	
	public class Iterator {
		private int currentI = -1;
		private Item currentItem = null;
		private Iterator() {}
		
		public boolean hasNext() {
			if(currentItem != null && currentItem.next != null)
				return true;
			else
				for(int i = currentI + 1; i <Set.this.buckets.length;i++){
					if(buckets[i] != null) return true;
				}
			return false;		
			// TODO
		}
		
		public String next() {
			if(currentItem != null && currentItem.next != null){
				currentItem = currentItem.next;
				return currentItem.value;
			} else {
				for(int i = currentI + 1; i<Set.this.buckets.length;i++){
					if(buckets[i] != null){
						currentI = i; currentItem = buckets[i];
						return currentItem.value;
					}
				}
			
			return null;
			}
			// TODO
		}
	}
	
	private final int N;
	private Item[] buckets;
	private int n = 0;
	
	public Set() {
		this(4);
	}
	
	private Set(int bucketCount) {
		N = bucketCount;
		buckets = new Item[bucketCount];
	}
	
	private int hash(String value) {
		int hash = 0;
		for(char c : value.toCharArray()) {
			hash = hash * 31 + c;
		}
		return Math.abs(hash);
	}
	
	public void add(String s) {
		if(!contains(s)) {
			int h = hash(s) % N;
			buckets[h] = new Item(s,buckets[h]);
			n++;
		}
		// TODO
	}
	
	public void remove(String s) {
		int h = hash(s) % N;
		Item f = buckets[h];
		if(s.equals(f.value) && f!= null) { 
			buckets[h] = f.next;
			//remove item
			return;
		}
		for( Item e = buckets[h];e!=null;e= e.next){
			if( e.next!= null && s.equals(e.next.value)){
				e.next = e.next.next;
				n--;
				return;
			}
		}
		return;
		// TODO
	}
	
	public boolean contains(String s) {
		int h = hash(s) % N;

		for(Item e = buckets[h]; e!= null; e = e.next){
			if(s.equals(e.value)) return true;
		}
		return false;
		// TODO
	}
	
	public boolean isEmpty() {
		// TODO
		return n==0;
	}
	
	public int size() {
		// TODO
		return n;
	}
	
	public Iterator getIterator() {
		return new Iterator();
		
	}
	
	public Set union(Set other) {
		Set result = new Set();
		Set.Iterator iter = this.getIterator();
		Set.Iterator iterOther = other.getIterator();
		while(iterOther.hasNext()){
			String e = iterOther.next();
			result.add(e);
		}
		while(iter.hasNext()){
			String e = iter.next();
			if(result.contains(e)) {
			} else {
				result.add(e);
			}
		}
		return result;
		// TODO
	}

	public Set intersection(Set other) {
		Set result = new Set();
		Set.Iterator iter = getIterator();
		while(iter.hasNext()){
			String e = iter.next();
			if(other.contains(e)) result.add(e);
		}
		return result;
		// TODO
	}	

	public Set difference(Set other) {
		Set result = new Set();
		Set.Iterator iter = getIterator();
		while(iter.hasNext()){
			String e = iter.next();
			if(other.contains(e)) {
			} else{
				result.add(e);
			}
		}
		return result;
		// TODO
	}
	
	public boolean isSubsetOf(Set other) {
		Set.Iterator iter = getIterator();
		while(iter.hasNext()){
			String e = iter.next();
			if(other.contains(e)){ 
			} else{
				return false;
			}
		}
		return true;
		// TODO
	}
	
	public String toString() {
		Set.Iterator iter = this.getIterator();
		String result= "";
		while(iter.hasNext()) {
			result += iter.next();
			if(iter.hasNext()) {
				result += ", ";
			} else {
				result += "";
			}
		}
		return result;
		// TODO
	}
	
	public static void main(String[] args) {
		Set set = new Set();
		
		String[] testWordsA = {"there", "which", "picture", "their", "other", "small", "large"};
		String[] testWordsB = {"there", "which", "picture", "change", "spell", "animal", "house"};
		
		System.out.println("Creating set:");
		for(String s : testWordsA) {
			set.add(s);
			System.out.println("Added '" + s + "' to set");
		}
		
		System.out.println("\nSet size (should be " + testWordsA.length + "): " + set.size());
	
		for(String s : testWordsA) {
			System.out.println("Check if '" + s + "' is indeed in set: " + set.contains(s));
		}

		System.out.println("\nSet contains:");
		Set.Iterator iter = set.getIterator();
		while(iter.hasNext()) {
			System.out.print(iter.next());
			if(iter.hasNext()) {
				System.out.print(", ");
			} else {
				System.out.println("");
			}
		}

		System.out.println("\nCreating other set:");
		Set otherSet = new Set();
		for(String s : testWordsB) {
			otherSet.add(s);
			System.out.println("Added '" + s + "' to other set");
		}

		System.out.println("\nSet A: " + set);
		System.out.println("Set B: " + otherSet);
		otherSet.remove("there");
		System.out.println("Set B: " + otherSet);
		
		Set intersection = set.intersection(otherSet);
		System.out.println("\nIntersection contains:");
		System.out.println(intersection);
		
		Set union = set.union(otherSet);
		System.out.println("\nUnion contains:");
		System.out.println(union);
		
		Set difference = set.difference(otherSet);
		System.out.println("\nDifference contains:");
		System.out.println(difference);
		
		Set subsetA = new Set();
		subsetA.add(testWordsA[5]);
		subsetA.add(testWordsA[6]);
		
		Set subsetB = new Set();
		subsetB.add(testWordsB[5]);
		subsetB.add(testWordsB[6]);

		System.out.println("\nTesting subsets:");
		System.out.println("Is " + subsetA + " subset of " + set + ": " + subsetA.isSubsetOf(set));
		System.out.println("Is " + subsetB + " subset of " + set + ": " + subsetB.isSubsetOf(set));
		
		System.out.println("\nRemoving element (" + testWordsA[2] + "):");
		System.out.println("Before: " + set);
		set.remove(testWordsA[2]);
		System.out.println("After: " + set);
	}
}
