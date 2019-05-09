import java.lang.Math;
import java.util.ArrayList;

public class BTree<E> {

	class Node<F> {
		private F data;
		private Node<F> left;
		private Node<F> right;
		// Constructors
		
		public Node(F data, Node<F> left, Node<F> right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public Node(F data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
	}
	// Data fields
	private Node<E> root;
	
	// Constructor
	
	public BTree() {
		super();
		root=null;
	}
	
	public BTree(E data) {
		super();
		root=new Node<E>(data);
	}
	
	public BTree(E data, BTree<E> left, BTree<E> right) {
		super();
		root = new Node<E>(data,left.root,right.root);
	}
	
	private String toString(int l, Node<E> current) {
		StringBuilder s = new StringBuilder();
		
		for (int i=0; i<l; i++) {
			s.append("--");
		}
		
		if (current==null) {
			s.append("null\n");
		} else {
			s.append(current.data.toString()+"\n");
			s.append(toString(l+1,current.left));
			s.append(toString(l+1,current.right));
		}
		return s.toString();
		
	}
	
	public String toString() {
		return toString(0,root);
	}
	
	private int height(Node<E> current) {
		if (current==null) {
			return 0;
		} else {
			return Math.max(height(current.left), height(current.right))+1;
		}
	}
	
	public int height() {
		return height(root);
	}
	
	private Node<E> mirror(Node<E> current) {
		if (current==null) {
			return current;
		} else {
			Node<E> temp = current.left;
			current.left = mirror(current.right);
			current.right = mirror(temp);
			return current;
		}
	}
	
	public void mirror() {
		root = mirror(root);
	}

	private int no_of_nodes(Node<E> current) {
		if (current==null) {
			return 0;
		} else {
			return 1 + no_of_nodes(current.left)+no_of_nodes(current.right);
		}
	}
	
	public int no_of_nodes() {
		return no_of_nodes(root);
	}

	private boolean is_leaf(Node<E> current) {
		return (current.left == null && current.right == null);
	}

	public boolean is_leaf() {
		return is_leaf(root);
	}

	private Node<E> clip(int l, Node<E> current) {
		if (current == null) {
			return null;
		}
		if (l == 0) {
			return null;
		}
		//current is non-null and the level l>0
		current.left = clip(l-1, current.left);
		current.right = clip(l-1, current.right);
		return current;
	}

	/*
	public void clip(int l) {
		root=clip(l,root);
	}
	public void clip(int l) {

	} */

	private boolean is_full(Node<E> current) {
		if (current.left == null && current.right == null)
			return true;
		else if (current.left == null && current.right != null)
			return false;
		else if (current.left != null && current.right == null)
			return false;
		return (is_full(current.left) && is_full(current.right));
	}

	public boolean is_full() {
		return is_full(root);
	}

	private boolean is_balanced(Node<E> current) {
		int lHeight = height(current.left);
		int rHeight = height(current.right);
		return (Math.abs(rHeight - lHeight) <= 1);
	}

	public boolean is_balanced() {
		return is_balanced(root);
	}

	private boolean is_perfect(Node<E> current) {
		if (!(is_full(current)))
			return false;
		else if (height(current.left) != height(current.right))
			return false;
		return (is_perfect(current.left) && is_perfect(current.right));
	}

	public boolean is_perfect() {
		return is_perfect(root);
	}

	public BTree<E> cloneAt(Node<E> current) {
		if (current == null)
			return new BTree<>();
		if (is_leaf(current))
			return new BTree<>(current.data);
		return new BTree<>(current.data, cloneAt(current.left), cloneAt(current.right));
	}

	private ArrayList<ArrayList<Integer>> paths(Node<E> lr) {
		if (lr == null)
			return new ArrayList<>();
		else if (is_leaf(lr)) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<>();
			result.add(new ArrayList<>());
			return result;
		}
		else {
			ArrayList<ArrayList<Integer>> r = paths(lr.right);
			for (ArrayList<Integer> x :r) {
				x.add(0, 1);
			}
			ArrayList<ArrayList<Integer>> l = paths(lr.left);
			for (ArrayList<Integer> x: l) {
				x.add(0, 0);
			}
			l.addAll(r);
			return l;
		}
	}

	public ArrayList<ArrayList<Integer>> paths() {
		return paths(root);
	}

	
	public static void main(String[] args) {
		BTree<Integer> leaf7 = new BTree<>(7);
		BTree<Integer> leaf24 = new BTree<>(24);
		BTree<Integer> t = new BTree<>(12,leaf7,new BTree<>(43,leaf24,new BTree<>()));
	
		System.out.println(t);
		System.out.println(t.height());
		t.mirror();
		System.out.println(t);
		System.out.println(t.no_of_nodes());

		BTree<Integer> a = new BTree<>(5);
		BTree<Integer> b = new BTree<>(9);
		BTree<Integer> c = new BTree<>(11, a, b);
		BTree<Integer> e = new BTree<>();
		BTree<Integer> d = new BTree<>(3, c, e);
		BTree<Integer> f = new BTree<>(4, d, e);

		System.out.println(a.is_leaf());
		System.out.println(c.is_leaf());

		System.out.println(c.is_full());
		System.out.println(d.is_full());

		System.out.println(c.is_balanced());
		System.out.println(f.is_balanced());

//		System.out.println(c.is_perfect());
		System.out.println(f.is_perfect());

	}
	
}
