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
    private TreeNode helper(int[] preorder, int[] i, int bound) {
        // Base case: out of bounds or current element exceeds upper bound for this subtree
        if (i[0] >= preorder.length || preorder[i[0]] > bound) {
            return null;
        }

        // Construct current root and increment index pointer
        TreeNode root = new TreeNode(preorder[i[0]++]);

        // Left subtree values must be < root.val
        root.left = helper(preorder, i, root.val);

        // Right subtree values must be < parent bound
        root.right = helper(preorder, i, bound);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] i = {0}; // Passed as 1-element array to simulate pointer/reference behavior in Java
        return helper(preorder, i, Integer.MAX_VALUE);
    }
}