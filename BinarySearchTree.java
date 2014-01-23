public class BinarySearchTree {
	private class Node {
		public double value;
		Node left, right;
		
		public Node(double value) {
			this.value = value;
		}
	}
	
	private Node root = null;
	
	public void insert(double value) {
		// TODO
	}
	
	public void insert(double[] values) {
		for(double v : values) {
			insert(v);
		}
	}
		
	public boolean isEmpty() {
		// TODO
	}
	
	public boolean contains(double value) {
		// TODO
	}
	
	public double nearest(double value) {
		// TODO
	}
	
	public int size() {	
		// TODO
	}
	
	public int countLeaves() {
		// TODO
	}

	
	public String toString() {
		// TODO
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
		
		test(tree.nearest(1.01) == 1.0, "nearest() works properly", 
									    "nearest() doesn't work properly");
		
		System.out.println("Tree has " + tree.countLeaves() + " leaves");
	}
}
