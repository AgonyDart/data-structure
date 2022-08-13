package linkedlist;

public class List {
    // First node pointer
    private Node header;
    private int length;

    // We will control the flow of the info with these nodes
    private class Node {

        // Book is the type of data we're going to save
        public Book book;
        // 'null' is the def value of the node pointer
        public Node next = null;

        public Node(Book book) {
            this.book = book;
        }
    }

    // This function insert a node at the beginning
    public void insertChild(Book book) {
        // Creates the new node
        Node node = new Node(book);
        // The node will point at the 'old' list (if there's any)
        node.next = header;
        // Now the header points the new node
        header = node;
        // Increase the length attr of the list
        length++;
    }

    // This function insert a node at the final
    public void appendChild(Book book) {
        Node node = new Node(book);
        // Make an aux-var to traverse the list
        Node pointer = header;
        if (header == null) {
            // if the list is empty, then our first node will be this new one
            header = node;
        } else {
            // Each node should be pointing to the next, the final one is pointing at null
            // so, this loop will carry us til' the final
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            // Once the end is reached, now it'll point at the new node
            pointer.next = node;
        }
        length++;
    }

    // This function insert a node after a specific one
    public void insertAfter(int number, Book book) {
        Node node = new Node(book);
        if (header == null) {
            header = node;
        } else {
            Node pointer = header;
            // Make an aux-var to count until the element we want to
            int count = 0;
            while (count < number && pointer.next != null) {
                pointer = pointer.next;
                count++;
            }
            // connect the new node to the 'rigth' list flow
            node.next = pointer.next;
            // connect the new node to the 'left' list flow
            pointer.next = node;
        }
        length++;
    }

    // Get the info at any specific point in the list
    public Book get(int number) {
        if (header == null) {
            return null;
        } else {
            Node pointer = header;
            int count = 0;
            while (count < number && pointer.next != null) {
                pointer = pointer.next;
                count++;
            }
            // If even after going through didn't catch up on the number, then there's no
            // node
            if (count != number) {
                return null;
            } else {
                return pointer.book;
            }
        }
    }

    public int count() {
        return length;
    }

    public boolean isEmpty() {
        return header == null;
    }

    public void removeFirstChild() {
        if (header != null) {
            // Def aux-var to relocate the header
            Node first = header;
            // Pass the header to the second node
            header = header.next;
            // Get out of the road the first
            first.next = null;
            // Decrease the length of the list
            length--;
        }
    }

    public void removeLastChild() {
        if (header != null) {
            if (header.next == null) {
                header = null;
            } else {
                Node pointer = header;
                // Before the last one (.next.next) overwrite the data
                while (pointer.next.next != null) {
                    pointer = pointer.next;
                }
                pointer.next = null;
            }
            length--;
        }
    }

    public void removeNthChild(int number) {
        if (header != null) {
            if (number == 0) {
                Node first = header;
                header = header.next;
                first.next = null;
            } else if (number < length) {
                Node pointer = header;
                int count = 0;
                while (count < (number - 1)) {
                    pointer = pointer.next;
                    count++;
                }
                // aux-var to relocate the pointer of the previous node to the following node
                // that is removing
                Node temp = pointer.next;
                pointer.next = temp.next;
                // "Clean" the reference to the aux-var in order to eliminate missing pointers
                temp.next = null;
            }
            length--;
        }
    }
}