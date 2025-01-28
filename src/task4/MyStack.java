package task4;

import task2.MyLinkedList;

public class MyStack<T> {
    private int size;
    private Node<T> head;
    private Node<T> last;

    public MyStack() {
        this.size = 0;
    }

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
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

    public void push(T value) {

        if (size == 0) {
            Node<T> newNode = new Node<>(value, null, null);
            this.head = newNode;
            this.last = newNode;
        } else {
            Node<T> newNode = new Node<>(value, last, null);
            last.next = newNode;
            this.last = newNode;
        }

        size++;
    }

    public void remove(int index) {
        checkIndex(index);

        Node<T> currentNode = getNodeByIndex(index);

        if (size == 1) {
            this.head = null;
            this.last = null;
        } else if (currentNode.prev == null) {
            this.head = currentNode.next;
            head.prev = null;

        } else if (currentNode.next == null) {
            this.last = currentNode.prev;
            last.next = null;

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
            currentNode.value = null;
            currentNode.prev = null;
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
        return (last == null) ? null : last.value;
    }

    public T pop() {
        if (last == null) {
            return null;
        }

        Node<T> node = last;
        last.prev.next = null;
        last = last.prev;
        if (node == head) {
            this.head = null;
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
