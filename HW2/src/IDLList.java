public class IDLList<E> {

    private class Node<F> {
        // Data fields
        private F data;
        private Node<F> next;
        private Node<F> prev;

        // Constructors
        Node() {
            data=null;
            next=null;
            prev=null;
        }

        Node(F data){
            this.data=data;
            next=null;
            prev=null;
        }

        Node(F data, Node<F> next) {
            this.data=data;
            this.next=next;
            this.prev = prev;
        }
    }
}
