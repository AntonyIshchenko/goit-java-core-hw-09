package task5;

import java.util.Objects;

public class MyHashMap<K, V> {
    private int size;
    private Node<K, V>[] buckets;

    public MyHashMap() {
        this.size = 0;
        this.buckets = (Node<K, V>[]) new Node[10];
    }

    private static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public boolean keyEquals(Object obj) {
            if (key == obj) {
                return true;
            }

            if (!(obj.getClass() == key.getClass())) {
                return false;
            }

            K o = (K) obj;

            return key.equals(o);
        }

        public final String toString() {
            return key + ":" + value;
        }
    }

    private int getHash(K key) {
        return Objects.hashCode(key);
    }

    private int getBucketIndex(int hash) {
        return hash % 10;
    }

    private Node<K, V>[] getNodeByKey(K key, boolean findLastBucketNode, boolean findPreviousNode) {
        // index 0 - seekNode, 1 - lastBucketNode, 2 - prevNode
        Node<K, V>[] result = new Node[3];

        int hash = getHash(key);
        int bucketIndex = getBucketIndex(hash);

        Node<K, V> currentNode = buckets[bucketIndex];
        if (currentNode == null) {
            return result;
        }

        boolean isSeekNodeFound = false;
        while (currentNode != null) {
            if (!isSeekNodeFound && currentNode.hash == hash && currentNode.keyEquals(key)) {
                isSeekNodeFound = true;
                result[0] = currentNode;
                if (!findLastBucketNode) {
                    break;
                }
            }

            if (currentNode.next == null) {
                if (findLastBucketNode) {
                    result[1] = currentNode;
                }
                break;
            } else {
                if (findPreviousNode) {
                    result[2] = currentNode;
                }

                currentNode = currentNode.next;
            }
        }

        return result;
    }

    public void put(K key, V value) {
        Node<K, V>[] nodesData = getNodeByKey(key, true, false);
        Node<K, V> existingNode = nodesData[0];
        Node<K, V> lastBucketNode = nodesData[1];

        if (existingNode != null) {
            existingNode.setValue(value);
        } else {
            int hash = getHash(key);
            Node<K, V> newNode = new Node<>(hash, key, value, null);

            if (lastBucketNode == null) {
                int bucketIndex = getBucketIndex(hash);
                buckets[bucketIndex] = newNode;
            } else {
                lastBucketNode.next = newNode;
            }
            size++;
        }
    }

    public V remove(K key) {
        Node<K, V>[] nodesData = getNodeByKey(key, false, true);
        Node<K, V> existingNode = nodesData[0];
        Node<K, V> previousNode = nodesData[2];

        if (existingNode == null) {
            return null;
        }

        if (previousNode == null) {
            int hash = getHash(key);
            int bucketIndex = getBucketIndex(hash);

            buckets[bucketIndex] = existingNode.next;
        } else {
            previousNode.next = existingNode.next;
        }

        size--;
        V oldValue = existingNode.value;
        existingNode.next = null;
        existingNode.value = null;

        return oldValue;
    }

    public void clear() {
        if (size == 0) {
            return;
        }

        for (int i = 0; i < 10; i++) {
            Node<K, V> node = buckets[i];
            while (node != null) {
                Node<K, V> nextnode = node.next;
                node.setValue(null);
                node.next = null;

                node = nextnode;
            }

            buckets[i] = null;
        }

        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        Node<K, V>[] nodesData = getNodeByKey(key, false, false);

        return nodesData[0] == null ? null : nodesData[0].value;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            Node<K, V> node = buckets[i];
            while (node != null) {
                result.append(node.toString());
                result.append(", ");
                node = node.next;
            }
        }


        String res = result.toString().trim();
        int lastIndex = res.length() == 0 ? 0 : res.length() - 1;

        return "[" + res.substring(0, lastIndex) + "]";
    }
}
