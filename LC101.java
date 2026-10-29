class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        // Compare the left and right subtrees starting from the root
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // Base case 1: If both are null, they match symmetrically
        if (t1 == null && t2 == null) return true;
        
        // Base case 2: If only one is null (or values don't match), it's not symmetric
        if (t1 == null || t2 == null || t1.val != t2.val) return false;

        // Recursive step: 
        // 1. Compare t1's left with t2's right (outer pair)
        // 2. Compare t1's right with t2's left (inner pair)
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}