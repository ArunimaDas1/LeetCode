/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null); // Mark the end of a level

        Node prev = null;

        while (q.size() > 0) {
            Node curr = q.poll(); // q.front() + q.pop() in C++

            if (curr == null) {
                if (q.size() == 0) {
                    break;
                }
                q.add(null); // Push delimiter for the next level
                prev = null; // Reset prev for the new level
            } else {
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }

                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;
            }
        }

        return root;
    }
}