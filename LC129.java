class Solution {
    // Class-level accumulator to collect the final sum
    private int totalSum = 0;

    private void dfs(TreeNode root, int currentSum) {
        if (root == null) {
            return;
        }

        // Build the number for the current path
        currentSum = currentSum * 10 + root.val;

        // If it's a leaf node, add this path's number to our totalSum
        if (root.left == null && root.right == null) {
            totalSum += currentSum;
            return;
        }

        // Recurse left and right
        dfs(root.left, currentSum);
        dfs(root.right, currentSum);
    }

    public int sumNumbers(TreeNode root) {
        totalSum = 0; // Reset for safety
        dfs(root, 0);
        return totalSum;
    }
}