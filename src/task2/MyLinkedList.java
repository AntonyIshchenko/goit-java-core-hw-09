package task2;

public class MyLinkedList<T> {
    private int size;
    private Node<T> head;

    public MyLinkedList() {
        this.size = 0;
    }

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.prev = previous;
            this.next = next;
        }
    }

    private Node<T> getNodeByIndex(int index) {
        int i = 0;

        Node<T> result = head;
        while (i < index) {
            result = result.next;
            i++;
        }

        return result;
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
    }

    public void add(T value) {
        if (size == 0) {
            this.head = new Node<>(value, null, null);
        } else {
            Node<T> lastNode = getNodeByIndex(size - 1);

            Node<T> newNode = new Node<>(value, lastNode, null);
            lastNode.next = newNode;
        }
        size++;
    }

    public void remove(int index) {
        checkIndex(index);

        Node<T> currentNode = getNodeByIndex(index);

        if (size == 1) {
            this.head = null;
        } else if (currentNode.prev == null) {
            this.head = currentNode.next;
            head.prev = null;
        } else if (currentNode.next == null) {
            currentNode.prev.next = null;
        } else {
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        }

        currentNode = null;
        size--;
    }

    public void clear() {
        if (size == 0) {
            return;
        }

        Node<T> currentNode = head;
        do {
            Node<T> nextNode = currentNode.next;
            currentNode.prev = null;
            currentNode.value = null;
            currentNode.next = null;

            currentNode = nextNode;
        } while (currentNode != null);

        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        checkIndex(index);

        return getNodeByIndex(index).value;
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
