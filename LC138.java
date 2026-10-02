/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // HashMap to store mapping from Original Node -> Cloned Node
        HashMap<Node, Node> m = new HashMap<>();

        // Create head copy and map it
        Node newHead = new Node(head.val);
        Node oldTemp = head.next;
        Node newTemp = newHead;
        m.put(head, newHead);

        // Pass 1: Copy nodes and build next links + populate map
        while (oldTemp != null) {
            Node copyNode = new Node(oldTemp.val);
            m.put(oldTemp, copyNode);
            newTemp.next = copyNode;

            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        // Pass 2: Connect random pointers using the map lookups
        oldTemp = head;
        newTemp = newHead;
        while (oldTemp != null) {
            newTemp.random = m.get(oldTemp.random); // null if oldTemp.random is null
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        return newHead;
    }
}