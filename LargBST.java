/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Helper class to store subtree information
    private static class NodeInfo {
        boolean isBST;
        int size;
        int min;
        int max;

        NodeInfo(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    private int maxSize = 0;

    public int largestBST(TreeNode root) {
        maxSize = 0;
        solve(root);
        return maxSize;
    }

    private NodeInfo solve(TreeNode root) {
        // Base case: null node is a valid BST of size 0
        if (root == null) {
            return new NodeInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // Postorder traversal: evaluate left and right subtrees first
        NodeInfo left = solve(root.left);
        NodeInfo right = solve(root.right);

        // Check if current subtree rooted at `root` forms a valid BST
        if (left.isBST && right.isBST && left.max < root.val && root.val < right.min) {
            int currentSize = left.size + right.size + 1;
            maxSize = Math.max(maxSize, currentSize);

            int currentMin = Math.min(root.val, left.min);
            int currentMax = Math.max(root.val, right.max);

            return new NodeInfo(true, currentSize, currentMin, currentMax);
        }

        // If not a valid BST, return isBST = false
        return new NodeInfo(false, 0, 0, 0);
    }
}