package queue;

public class QueueProcessor implements Queue {
    // Beside the known pointer 'header' to the first, we have now 'last'
    private NodeProcessor header, last;

    // Node anatomy
    private class NodeProcessor {
        public Work labor;
        public NodeProcessor next;

        public NodeProcessor(Work labor) {
            this.labor = labor;
            this.next = null;
        }
    }

    @Override
    // This will add a task at the end of the queue
    public void add(Work task) {
        // Creates a new node with the task
        NodeProcessor newNode = new NodeProcessor(task);
        // If the queue is empty then this new node is the first
        if (header == null) {
            header = newNode;
        // if not, we set it at the final
        } else {
            last.next = newNode;
        }
        last = newNode;
    }

    @Override
    // This will remove the task at the beginning of the queue
    public void remove() {
        // If queue is not empty:
        if (header != null) {
            NodeProcessor eliminate = header;
            header = header.next;
            eliminate.next = null;
            // If queue gets empty:
            if (header == null) {
                last = null;
            }
        }
    }

    @Override
    // If the queue is not empty, this will return the next task in the q.
    public Work get() {
        if (header == null) {
            return null;
        } else {
            return header.labor;
        }
    }

    // Combine get() and remove(), because once the task is complete it should be removed
    public Work settle() {
        if (header != null) {
            NodeProcessor eliminate = header;
            header = header.next;
            eliminate.next = null;
            // If queue gets empty:
            if (header == null) {
                last = null;
            }
            return eliminate.labor;
        } else {
            return null;
        }
    }
}
