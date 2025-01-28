package task3;

public class MyQueue<T> {
    private int size;
    private Node<T> head;
    private Node<T> last;

    public MyQueue() {
        this.size = 0;
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value, null);

        if (size == 0) {
            this.head = newNode;
        } else {
            last.next = newNode;
        }
        this.last = newNode;
        size++;
    }

    public void clear() {
        if (size == 0) {
            return;
        }

        Node<T> currentNode = head;
        do {
            Node<T> nextNode = currentNode.next;
            currentNode.value = null;
            currentNode.next = null;

            currentNode = nextNode;
        } while (currentNode != null);

        head = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return (head == null) ? null : head.value;
    }

    public T poll() {
        if (head == null) {
            return null;
        }

        Node<T> node = head;
        this.head = head.next;
        if (node == last) {
            this.last = null;
        }
        size--;

        return node.value;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        Node<T> node = head;

        while (node != null) {
            result.append(node.value.toString());

            node = node.next;
            if (node != null) {
                result.append(", ");
            }
        }

        result.append("]");

        return result.toString();
    }
}
