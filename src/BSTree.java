public class BSTree<E extends Comparable> {
    public class Node<E> {
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

        public void copy(Node<E> node) {
            data = node.data;
            left = node.left;
            right = node.right;
        }
    }
    Node<E> root;

    public BSTree(E elem){
        root = new Node<E>(elem);
    }

    public Node<E> getRoot(){
        return root;
    }

    public void add(E elem){
        Node<E> newNode = new Node<>(elem);
        if (root == null) {
            root = newNode;
        }
        else{
            add(root, newNode);
        }
    }

    public void add(Node<E> node, Node<E> newNode){
        if(node.data.compareTo(newNode.data) <= 0) {
            // Left is <= the current node
            if(node.left == null) {
                node.left = newNode;
                return;
            }
            add(node.left, newNode);

        }
        else{
            // Right is > the current node
            if(node.right == null) {
                node.right = newNode;
                return;
            }
            add(node.right, newNode);
        }
    }

    public boolean remove(E elem){

    }

    public boolean remove(Node<E> node, E elem) {
        if(node.data.compareTo(node.data)< 0) {
            // Left is <= the current node
            if(node.left == null) {
                return false;
            }
            remove(node.left, elem);
        }
        else if(node.data.compareTo(node.data) > 0) {
            if(node.right == null) {
                return false;
            }
            remove(node.right, elem);
        }
        else{
            if(node.left == null && node.right == null) {
                node = null;
                return true;
            }
            if(node.left != null && node.right != null) {

            }
            if(node.left != null) {
                node.copy(node.left);
                return true;
            }
            if(node.right != null) {
                node.copy(node.right);
            }
        }
    }

    public Node<E> rotateLeft(Node<E> node){
        if (node.right == null) {// We cannot rotate
            return node;
        }
        Node<E> saved = node.right;
        while(saved.left != null) {
            saved = rotateRight(saved);
        }
        saved.left = node;
        node.right = null;
        return saved;
    }

    public Node<E> rotateRight(Node<E> node){
        if (node.left == null) {// We cannot rotate
            return node;
        }
        Node<E> saved = node.left;
        while(saved.right != null) {
            saved = rotateLeft(saved);
        }
        saved.right = node;
        node.left = null;
        return saved;
    }

    public void print() {
        print("", root, false);
    }

    public void print(String prefix, Node<E> n, boolean isLeft) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

    public static void main(String[] args) {
        BSTree<Integer> tree = new BSTree<>(5);
        System.out.println(tree.getRoot().data);
        tree.print();
    }
}
