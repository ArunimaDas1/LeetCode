import java.util.HashMap;

class LRUCache {

    // Doubly Linked List Node
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        // Dummy head and tail nodes to avoid null checks during insertions/deletions
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        // Move the accessed node to the front (Most Recently Used)
        remove(node);
        insertAtHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Key exists: update value and move to front
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAtHead(node);
        } else {
            // Key is new: evict LRU item if capacity is reached
            if (map.size() == capacity) {
                Node lruNode = tail.prev;
                map.remove(lruNode.key);
                remove(lruNode);
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAtHead(newNode);
        }
    }

    // Helper: Remove node from DLL
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: Insert node right after dummy head (MRU positionHere is the optimal $O(1)$ time complexity Java solution for **LeetCode 146: LRU Cache** using a **Doubly Linked List + HashMap**.

---

### Optimal Java Implementation

```java
import java.util.HashMap;

class LRUCache {

    // Doubly Linked List Node
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head; // Dummy head (Most Recently Used side)
    private final Node tail; // Dummy tail (Least Recently Used side)

    public LRUCache(int capacity) {
        this.capacity = capacity;