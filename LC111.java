class Solution {
    public int minDepth(TreeNode root) {
        // Base case: empty tree has depth 0
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        // If left subtree is missing, path MUST go through right child
        if (root.left == null) {
            return 1 + rightDepth;
        }

        // If right subtree is missing, path MUST go through left child
        if (root.right == null) {
            return 1 + leftDepth;
        }

        // When both children exist, take the minimum of both
        return 1 + Math.min(leftDepth, rightDepth);
    }
}