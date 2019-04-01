package LinkedList;

public class SinglyLinkedList<T> {

	public Node<T> head;
	public Node<T> tail;
	public int size;
	
	public boolean isEmpty(){
		return (head == null);
	}
	
	public int getSize(){
		return size;
	}
	
	public void insertAfter(T element, T after){
		
		Node<T> node = new Node<T>(element);
		size++;
		
		if(isEmpty()){
			head = node;
		}
		
		Node<T> tmp = head;
		
		
	}
	
	public void addFront(T element){
		
		Node<T> newNode = new Node<T>(element);
		size++;
		
		if(isEmpty()){
			head = newNode;
			tail = newNode;
		}else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void addLast(T element){
		Node<T> newNode = new Node<T>(element);
		size++;
		
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		}else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	
	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
		linkedList.addFront(6);
		linkedList.addFront(10);
		linkedList.addFront(1);
		linkedList.addFront(3);
		
		System.out.println("Head:- "+linkedList.head + "\n" + "Tail:- " + linkedList.tail);
		
	}

}