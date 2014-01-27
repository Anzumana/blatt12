public class Stack {
	private class Node {
		Object value;
		Node next;
		
		public Node(Object value) {
			this(value, null);
		}
		
		public Node(Object value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	private Node root;
	
	public void push(Object value) {
		if(root == null) {
			root = new Node(value);
		} else {
			root = new Node(value, root);
		}
	}
	
	public Object pop() {
		if(root == null) {
			return null;
		} else {
			Object value = root.value;
			root = root.next;
			return value;
		}
	}
	
	public boolean isEmpty() {
		return root == null;
	}
}
