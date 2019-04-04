import java.util.ArrayList;

public class BTree<E> {
    private class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;

        Node(E data) {
            this.data = data;
        }

        Node(E data, Node<E> left, Node<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    Node<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E data) {
        root = new Node<E>(data);
    }

    public BTree(E data, BTree<E> lt, BTree<E> rt) {
        root = new Node<E>(data, lt.root, rt.root);
    }

    /**
     * Height of the tree
     */
    public int height() {
        return height_helper(root);
    }

    private int height_helper(Node<E> node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(height_helper(node.left), height_helper(node.right));
    }

    /**
     * Total number of nodes in tree
     */
    public int size() {
        return size_helper(root);
    }

    private int size_helper(Node<E> node) {
        if(node == null) {
            return 0;
        }
        return 1 + height_helper(node.left) + height_helper(node.right);
    }

    /**
     * Is it a leaf
     */
    public boolean isLeaf() {
        return isLeaf_helper(root);
    }

    public boolean isLeaf_helper(Node<E> node) {
        return node.left == null && node.right == null;
    }

    /**
     * All inner nodes have two children
     */
    public boolean isFull() {
        return isFull_helper(root);
    }

    private boolean isFull_helper(Node<E> node) {
        if(node == null) {
            return true;
        }
        if(node.left == null && node.right == null) {
            return true;
        }
        if(node.left == null && node.right != null || node.left != null && node.right == null) {
            return false;
        }

        return isFull_helper(node.left) && isFull_helper(node.right);
    }

    /**
     * All levels are completely filled except the last one and nodes are left aligned
     */
    public boolean isComplete() {
        return isComplete_helper(root, 1, this.size());
    }

    public boolean isComplete_helper(Node<E> node, int nodeNum, int maxSize) {
        if(node == null) {
            return true;
        }
        if(nodeNum > maxSize) {
            return false;
        }
        return isComplete_helper(node.left, nodeNum*2, maxSize) &&
                isComplete_helper(node.right, nodeNum*2+1, maxSize);
    }

    /**
     * All inner nodes have two children and all leaves are at the same level
     */
    public boolean isPerfect() {
        return (this.size() != (Math.pow(2, height()) - 1));
    }

    /**
     * Mirrors the current tree
     * @param current the thing being mirrored
     * @return the mirrored tree
     */
    private Node<E> mirror(Node<E> current) {
        if(current == null) {
            return null;
        }
        else{
            Node<E> temp = current.left;
            current.left = mirror(current.right);
            current.right = mirror(temp);
            return current;
        }
    }

    public void mirror() {
        root = mirror(root);
    }

    /**
     * Clips a binary tree at level l
     * @param l level to clip
     * @param current the tree
     * @return a tree that is clipped at level l
     */

    private Node<E> clip(int l, Node<E> current) {
        // base cases
        if(current == null || l == 0) {
            return null;
        }
        // current is non-null and the level l>0
        else {
            current.left = clip(l-1, current.left);
            current.right = clip(l-1, current.right);
        }
        return current;
    }

    public void clip(int l) {
        root = clip(l, root);
    }

    /**
     * Returns a new copy of the tree whose root is at the current node
     * @param current the current node
     * @return a new copy of the tree whose root is at the current node
     */
    public BTree<E> cloneAt(Node<E> current) {
        if(current == null) {
            return new BTree<E>();
        }
        return new BTree<E>(current.data, cloneAt(current.left), cloneAt(current.right));
    }


    /**
     * Creates a sequence of 1's and 0's that leads to a node in the tree
     * @param lr the node
     * @return a list with a sequence of 1's and 0's
     */
    private ArrayList<ArrayList<Integer>> paths(Node<E> lr) {
        if (lr == null) { // []
            return new ArrayList<ArrayList<Integer>>();
        }
        else if(this.isLeaf()) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            result.add(new ArrayList<Integer>());
            return result; //[[]]
        }
        else {
            ArrayList<ArrayList<Integer>> resultRight = paths(lr.right);
            for(ArrayList<Integer> l: resultRight) {
                l.add(0,1);
            }
            ArrayList<ArrayList<Integer>> resultLeft = paths(lr.left);
            for(ArrayList<Integer> l: resultLeft) {
                l.add(0,0);
            }
            resultLeft.addAll(resultRight);
            return resultLeft;
        }
    }

    public ArrayList<ArrayList<Integer>> paths() {
        return paths(root);
    }


    /**
     * Returns a list of all the ancestors of item
     * @param item the item whose ancestors are being returned
     * @return a list of all the ancestors of item
     */
    public ArrayList<E> ancestors(E item) {
        return null;
    }

    // Builds a readable string
    private StringBuilder toString(int l, Node<E> current) {
        StringBuilder r = new StringBuilder();

        for (int i = 0; i<l; i++) {
            r.append("--");
        }

        if(current==null) {
            r.append("null\n");
        }
        else {
            r.append(current.data.toString() + "\n");
            r.append(toString(l+1, current.left));
            r.append(toString(l+1, current.right));
        }
        return r;
    }

    public String toString() {
        return toString(0,root).toString();
    }

    public static void main(String[] args) {
//        BTree<Integer> t1 = new BTree<Integer>(23,new BTree<Integer>(12),new BTree<Integer>(27));
//		BTree<Integer> t2 = new BTree<Integer>(72,new BTree<Integer>(43),new BTree<Integer>(13));
//        BTree<Integer> t = new BTree<Integer>(34,t1,t2);
        BTree<Integer> leaf7 = new BTree<>(7);
        BTree<Integer> leaf24 = new BTree<>(24);
        BTree<Integer> t = new BTree(12,leaf7,new BTree<>(43,leaf24,new BTree<>()));
        System.out.println(t);
//        System.out.println(t);
//        System.out.println(t.height());
//        System.out.println(t.size());
        t.clip(1);
        System.out.println(t);

        /**
         *        34
         *       /  \
         *     23    72
         *    /  \  /  \
         *   12 27 43  13
         */
        
    }
}