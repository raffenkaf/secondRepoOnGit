package experimentsWithCollection;

public class Node <T>{
	private T value;
	private int number = -1;
	private Node<T> prevNode;
	private Node<T> nextNode;
	
	public Node(Node<T> prevNode, T value) {
		this.setPrevNode(prevNode);
		this.setValue(value);
	}
	
	public Node(Node<T> prevNode, T value, int index) {
		this.setNumber(index);
		this.setPrevNode(prevNode);
		this.setValue(value);
	}
	
	public Node(Node<T> prevNode, Node<T> nextNode, T value, int index) {
		this.setNumber(index);
		this.setPrevNode(prevNode);
		this.setValue(value);
		this.setNextNode(nextNode);
	}
	
	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode ) {
		this.nextNode = nextNode;
	}
	
	public Node<T> getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(Node<T> prevNode) {
		this.prevNode = prevNode;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
