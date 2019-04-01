// Node should be nested static class because it only exists along with linked list (Should be written in the LinkedListClass)
// Node should be private because it's implementation detail, and should not be exposed
package LinkedList;

//	1. A Link is an Object 
//	2. Each Link has a reference to another Link in the List 
//	3. The LinkedList has only a reference to the last Link added to it.

public class Node<T> {

	// reference to the next node in the chain,
	// or null if there isn't one.
	public Node<T> next;					// Set to public so getters & setters aren't needed
	// data carried by this node.
	// could be of any type you need.
	public T data;							// Set to public so getters & setters aren't needed
	
	public Node(T data) {
		super();
		this.data = data;
	}
	
	public Node() {
		// TODO Auto-generated constructor stub
	}

	public void displayName() {
		System.out.println(data + "");
	}

	@Override
	public String toString() {
		return data.toString();
	}
	
}
