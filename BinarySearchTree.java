public class BinarySearchTree {
	private class Node {
		public double value;
		Node left, right;
		
		public Node(double value) {
			this.value = value;
		}
		public Node(double value , Node left , Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		public String toString(){
			if(left == null && right ==null)
					return String.valueOf(value);
				return value + "(" + (left !=null ? left : "_")+","+(right!=null ? right :"_")+")";
		}	
		public Node search(double i, Node n){
			if(n== null) return null;
			if(n.value == i) return n;
			if( i<n.value) return search(i,n.left);
			else return search(i,n.right);
		}
		public nearest(double value,Node n){
		}
	}
	
	private Node root = null;
	private int size =0;
	
	public void insert(double value) {
		size ++;
		if (this.root == null) {
			root = new Node(value,null,null);
		} else{
			insert(value,this.root);
		}
	}
	private void insert(double value,Node n){
		if(value < n.value) {
			if(n.left == null) n.left = new Node(value,null,null); else insert(value,n.left);
		} else {
			if(n.right == null) n.right = new Node(value,null,null); else insert(value,n.right);
		}	
	}
	
	public void insert(double[] values) {
		for(double v : values) {
			insert(v);
		}
	}
		
	public boolean isEmpty() {
		if (this.root == null){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean contains(double value) {
		Node test = this.root.search(value,root);
		if( test!= null){
			return true;
		}
		return false;
	}
	
	
	public double nearest(double value) {
		if(root!= null){
				nearest(value, root);	
		} else{
			return Double.NaN;
		}
	}
	
	public int size() {	
		return size;
	}
	
	public int countLeaves() {
		// TODO
		return 1;
	}

	
	public String toString() {
		if( root == null){
			return "baum is leer";
		}
		return 	root.toString();
	}
	
	private static void test(boolean expr, String successMessage, String failMessage) {
		if(expr == true) {
			System.out.println(successMessage);
		} else {
			System.out.println(failMessage);
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		test(tree.isEmpty() == true, "isEmpty() properly returns false when it should", 
									 "isEmpty() returns true when it should return false");
		
		double[] testValues = {1.0, 3.0, -2.0, -6.4, 1.1, 5.0};
		tree.insert(testValues);
		System.out.println(tree);
		
		test(tree.isEmpty() == false, "isEmpty() properly returns true when it should", 
									  "isEmpty() returns false when it should return true");
		
		test(tree.size() == testValues.length, "size() returns correct results",
											   "size() returns incorrect results");
		
		test(tree.contains(testValues[2]), "contains() works properly", 
										   "contains() doesn't work properly");
		
/*
		test(tree.nearest(1.01) == 1.0, "nearest() works properly", 
									    "nearest() doesn't work properly");
		
		System.out.println("Tree has " + tree.countLeaves() + " leaves");
*/
	}
}
