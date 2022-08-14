package stack;

public class StackProcess implements Stack {
    // This will act as the pointer for the last added item
    private Node peek = null;
    private int length = 0;

    // Creating the node structure as the other examples
    private class Node {
        public URL url;
        public Node next = null;

        public Node(URL url) {
            this.url = url;
        }
    }

    @Override // Add to the stack fn
    public void push(URL url) {
        Node node = new Node(url);
        node.next = peek;
        peek = node;
        length++;
    }

    @Override
    public void pop() {
        if (peek != null) {
            Node remove = peek;
            peek = peek.next;
            remove.next = null;
            length--;
        }
    }

    @Override
    public URL get() {
        if (peek == null) {
            return null;
        } else {
            return peek.url;
        }
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }
}