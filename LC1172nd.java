class Solution {
    public Node connect(Node root) {
        // Tracks our position horizontally on the current level
        Node curr = root;

        while (curr != null) {
            // Dummy head acts as a secure starting anchor for the next level's linked list
            Node dummy = new Node(0);
            Node tail = dummy; // Tail pointer builds the next level forward
            
            // Sweep across the current level using existing 'next' pointers
            while (curr != null) {
                // If a left child exists, attach it to the tail
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }
                
                // If a right child exists, attach it to the tail
                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }
                
                // Move to the next node on the current level
                curr = curr.next;
            }

            // Drop down to the start of the next level (skipping the dummy node)
            curr = dummy.next;
        }

        return root;
    }
}