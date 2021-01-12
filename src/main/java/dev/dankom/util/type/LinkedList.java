package dev.dankom.util.type;

public class LinkedList<T> {

    private Node node;

    public LinkedList(Node node) {
        this.node = node;
    }

    public LinkedList(T value) {
        this.node = new Node(value);
    }

    public void add(Node node) {
        Node n = node;
        while (n.hasNext()) {
            n = n.next();
        }
        n.setNext(node);
    }

    public void set(T value, int index) {
        Node n = node;
        int i = 0;
        while (i < index) {
            n = n.next();
        }
        n.setValue(value);
    }

    public void set(T value, Node node) {
        Node n = node;
        while (n != node) {
            n = n.next();
        }
        n.setValue(value);
    }

    public T get(int index) {
        Node n = node;
        int i = 0;
        while (i < index) {
            n = n.next();
        }
        return n.getValue();
    }

    public T get(Node node) {
        Node n = node;
        while (n != node) {
            n = n.next();
        }
        return n.getValue();
    }

    public void remove(int index) {
        Node n = node;
        int i = 0;
        while (i < index) {
            n = n.next();
        }
        n.setPrev(n.next());
    }

    public void insert(Node node, int index) {
        Node n = node;
        int i = 0;
        while (i < index) {
            n = n.next();
        }
        n.setPrev(node);
        node.setNext(n);
    }

    class Node {
        private T value;
        private Node next;
        private Node prev;

        public Node(T value, Node node, Node prev) {
            this.value = value;
            this.next = node;
            this.prev = prev;
        }

        public Node(T value) {
            this(value, null, null);
        }

        public Node next() {
            return next;
        }

        public void setNext(Node node) {
            this.next = next;
        }

        public boolean hasNext() {
            return next != null;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }
}
