public class SinglyLinkedList<E> {
	private static class Node<E> {
		//Data fields
		E data;
		Node<E> next;
		
		//Constructors
		Node (E elem){
			//Creates a new node holding elem
			this.data = elem;
			this.next = null;
		}
		
		Node (E elem, Node<E> next) { 
			//Creates a new node holding elem with next as next
			this.data = elem;
			this.next = next;
		}
	}
	private Node<E> head;
	public SinglyLinkedList() {
		this.head = null;
	}
	public Node<E> getHead() {
		return head;
	}
	public void setHead(Node<E> head) {
		this.head = head;
	}

	public String toString() {
		String s = "";
		while (head != null) {
			s += head.data + " -> ";
			head = head.next;
		}
		s += "null";
		return s;
	}
	
	public boolean compare(SinglyLinkedList<E> l1) {
		if (this.head == null && l1.head == null) { return true; }
		if (this.head == null || l1.head == null) { return false; }
		while (this.head != null || l1.head != null) {
			if (this.head.data != l1.head.data) { return false; }
			this.head = this.head.next;
			l1.head = l1.head.next;
		}
		if (this.head == null && l1.head == null) {
			return true;
		}
		return false;
	}
	public Node<Integer> merge(Node<Integer> l1, Node<Integer> l2) {
		if (l1 == null && l2 == null) { return null; }
		if (l1 == null) { return l2; }
		if (l2 == null) { return l1; }
		if (l1.data <= l2.data) {
			l1.next = merge(l1.next, l2);
			return l1;
		}
		else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}
	public boolean hasACycle() {
		if (this.head == null) { return false; }
		Node<E> slow = this.head;
		Node<E> fast = this.head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) { return true; }
		}
		return false;
	}
	
	public E mergePoint(SinglyLinkedList<E> l1) {
		Node<E> current = this.head;
		Node<E> current1 = l1.head;
		while (current != current1) {
			if (current.next == null) {
				current = l1.head;
			}
			else {
				current = current.next;
			}
			
			if (current1.next == null) {
				current1 = this.head;
			}
			else {
				current1 = current1.next;
			}
		}
		return current.data;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> l1 = new SinglyLinkedList<Integer>();
		Node<Integer> n2 = new Node<Integer>(5);
		Node<Integer> n1 = new Node<Integer>(3, n2);
		l1.setHead(n1);
		System.out.println(l1);
	}
}
