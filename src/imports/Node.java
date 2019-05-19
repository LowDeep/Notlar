package imports;

public class Node<T> {
	private T value;
	private Node<T> next;
	
	public Node(T elem){
		this.value = elem;
	}
	
	public Node(T _val, Node<T> _next){
		this(_val);
		this.next = _next;
	}
	
	public T getData() {
		return this.value;
	}
	
	public void setData(T elem) {
		this.value = elem;
	}
	
	public Node<T> getNext(){
		return this.next;
	}
	
	public void setNext(Node<T> _next) {
		this.next = _next;
	}
	
	public boolean hasNext() {
		return this.next != null;
	}
	
}
