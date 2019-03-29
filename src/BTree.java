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

    public static void main(String[] args) {
        MyBTree<Integer> t1 = new MyBTree<Integer>(23,new MyBTree<Integer>(12),new MyBTree<Integer>(27));
		MyBTree<Integer> t2 = new MyBTree<Integer>(72,new MyBTree<Integer>(43),new MyBTree<Integer>(13));
        MyBTree<Integer> t = new MyBTree<Integer>(34,t1,t2);

        /**
         *        34
         *       /  \
         *     23    72
         *    /  \  /  \
         *   12 27 43  13
         */
        
    }
}