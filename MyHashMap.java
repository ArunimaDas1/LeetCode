import java.util.LinkedList;

public class MyHashMap<K, V> {

    // Node class to store key-value pairs
    private static class Node<K, V> {
        K key;
        V value;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node<K, V>>[] buckets;
    private int capacity;
    private int size;
    private static final double LOAD_FACTOR = 0.75;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        this.capacity = 16;
        this.buckets = new LinkedList[capacity];
        this.size = 0;
    }

    // Hash function: maps key to a bucket index
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    // Insert or update a key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        // If key already exists, update value
        for (Node<K, V> node : buckets[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        // Otherwise insert new node
        buckets[index].add(new Node<>(key, value));
        size++;

        // Resize if load factor exceeded
        if ((double) size / capacity >= LOAD_FACTOR) {
            resize();
        }
    }

    // Retrieve value for a key
    public V get(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return null;

        for (Node<K, V> node : buckets[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    // Remove a key-value pair
    public void remove(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return;

        buckets[index].removeIf(node -> {
            if (node.key.equals(key)) {
                size--;
                return true;
            }
            return false;
        });
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    // Double capacity and rehash all entries
    @SuppressWarnings("unchecked")
    private void resize() {
        LinkedList<Node<K, V>>[] oldBuckets = buckets;
        capacity *= 2;
        buckets = new LinkedList[capacity];
        size = 0;

        for (LinkedList<Node<K, V>> bucket : oldBuckets) {
            if (bucket != null) {
                for (Node<K, V> node : bucket) {
                    put(node.key, node.value);
                }
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        System.out.println("apple -> " + map.get("apple"));
        System.out.println("banana -> " + map.get("banana"));

        map.put("apple", 100); // update
        System.out.println("apple updated -> " + map.get("apple"));

        map.remove("banana");
        System.out.println("banana exists? " + map.containsKey("banana"));

        System.out.println("Size: " + map.size());
    }
}