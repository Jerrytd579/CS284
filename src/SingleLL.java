public class SingleLL<E> {

	class Node<F> {
		// Data fields
		private F data;
		private Node<F> next;
		
		// Constructors
		Node() {
			data=null;
			next=null;
		}
		
		Node(F data){
			this.data=data;
			next=null;
		}
		
		Node(F data, Node<F> next) {
			this.data=data;
			this.next=next;
		}
		
		// Methods
		public F getData() {
			return data;
		}
		
		public Node<F> getNext() {
			return next;
		}
	}
	// Data fields
	private Node<E> head;
	private int size;
	
	// Constructor
	SingleLL() {
		head=null;
		size=0;
	}
	
	// Methods
	public boolean isEmpty() {
		return size==0;
	}
	
	public void addFirst(E item) {
		   head = new Node<E>(item,head);
		   size++;
	}
	
	public void addLast(E item) {
		if (head==null) {
			this.addFirst(item);
		} else {
			Node<E> current = head;

			while (current.next!=null) {
				current=current.next;
			}

			current.next = new Node<E>(item);
			size++;
		}
	}
	
	public E get(int index) {
		if (index<0 || index>size-1) {
			throw new IllegalArgumentException();
		}
		Node<E> current = head;
		
		for(int i=0; i<index; i++) {
			current = current.next;
		}
		
		return current.data;
		
	}

	public int getSize() {
		return size;
	}
	
	public E removeFirst() {
		if (head==null) {
			throw new IllegalStateException();
		}
		E temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
	
	public E removeLast() {
		if (size==0) { // empty list
			throw new IllegalStateException();
		}
		if (size==1) { // singleton list
			return this.removeFirst();
		}
		// list has two or more elements
		Node<E> current=head;
		
		while(current.next.next!=null) {
			current=current.next;
		}
		E temp = current.next.data;
		size--;
		current.next = null;
		return temp;
		
		
	}
	
	public E remove(int index) {
		if (index<0 || index>size-1) {
			throw new IllegalArgumentException();
		}
		if (size==1) {
			return this.removeFirst();
		} else {
			Node<E> current=head;
			Node<E> previous=head;
			
			for (int i=0; i<index; i++) {
				previous = current;
				current = current.next;
			}
			E temp = current.data;
			size--;
			previous.next = current.next;
			return temp;
		}

	}

	public boolean member(E item) {
		Node<E> current=head;
		
		while (current!=null && !current.data.equals(item)) {
			current = current.next;
		}
		
		return current!=null;
	}
	
	
	public SingleLL<E> take(int n) {		
		SingleLL<E> l = new SingleLL<E>();
		
		int i = 0;
		Node<E> current = head;
		Node<E> last = new Node<E>();
		Node<E> newHead = last;
		while (current!=null && i<n) {
			last.next = new Node<E>(current.data);
			last = last.next;
			current = current.next;
			i++;
		}
		l.head = newHead.next;
			l.size = i+1;
		return l;
	}

	public SingleLL<E> take3(int n) {
		if (head==null || n==0) {
			head=null;
			size = 0;
		}

		else {
			int i = 0;
			Node<E> current = head;

			while (current !=null && i<n-1) {
				current = current.next;
				i++;
			}

			current.next = null;
			size = i;
		}
		return null;
	}

	public boolean isSingleton() {
		return head.next == null;
	}

	public boolean allNonNull() {

		Node<E> current = head;

		while(current.next != null) {
			current = current.next;
			if(current.data == null) {
				return false;
			}
		}
		return true;
	}

	public boolean mem(E el) {

		Node<E> current = head;

		while(current.next != null) {
			current = current.next;
			if(current.data == el) {
				return true;
			}
		}
		return false;
	}

	public boolean nonDuplicates() {

		Node<E> current = head;

		while(current.next != null) {
			Node<E> other = head;
			while(other.next != null) {
				if(current.data.equals(other.data)) {
					return false;
				}
			}
		}
		return true;
	}

//	public void removeAdjacentDuplicates() {
//		
//	}
//	
//	// requires Comparable 
//	public boolean isIncreasing() {
//		
//	}
//	
//	public SingleLL<E> reverse() {
//		
//	}
//	
	public void reverse() {
		SingleLL<E> l = new SingleLL<E>();

		if(head == null || head.next == null) {
			return;
		}
		// List has two or more elements
		Node<E> oldHead = head;
		Node<E> previous = head;
		Node<E> current = head.next;
		Node<E> temp;

		while(current != null) {
			temp = current;
			previous = previous.next;
			current = current.next;


		}

		oldHead.next = null;
		head = previous;


	}

	public SingleLL<Pair<E,E>> mergeLists(SingleLL<E> l) {
		Node<E> current1 = head;
		Node<E> current2 = l.head;
		SingleLL<Pair<E,E>> result = new SingleLL<>();

		while (current1!=null && current2!= null) {
			result.addLast(new Pair<E,E>(current1.data,current2.data));
			current1 = current1.next;
			current2 = current2.next;
		}

		return result;

	}

	public SingleLL<Pair<E,Integer>> compress() {
		Node<E> current = head;
		SingleLL<Pair<E, Integer>> r = new SingleLL<>();


		if(head == null) { // Empty List
			return r;
		}
		if(head.next == null) { // Singleton List
			r.addFirst(new Pair<E,Integer>(head.data, 1));
			return r;
		}

		int i = 1;
		while(current.next != null) {
			if (current.data.equals(current.next.data)) {
				i++;
				current=current.next;
			} else {
				r.addLast(new Pair<E, Integer>(current.data, i));
				i = 1;
				current = current.next;
			}
			r.addLast(new Pair<E,Integer>(current.data, i));
		}
		return r;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		s.append("[");
		Node<E> current = head;
		while (current!=null) {
			s.append(current.data.toString()+";");
			current = current.next;
		}
		s.append("]");
		return s.toString();
		
	}
	
	public static void main(String[] args) {
		SingleLL<Integer> l = new SingleLL<Integer>();
		
		l.addFirst(3);
		l.addFirst(2);
		l.addFirst(1);
		l.addLast(4);
		System.out.println(l);
		l.removeFirst();
		System.out.println(l);
		System.out.println(l.take(10));
		System.out.println(l.take(0));
		System.out.println(l.take(1));
		System.out.println(l.take(2));

//		System.out.println(l.member(4));
//		System.out.println(l.member(7));
		
	}
 }
