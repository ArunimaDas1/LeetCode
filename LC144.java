import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val); // 1. Process Root

            // 2. Push Right child FIRST so Left is popped first
            if (curr.right != null) {
                stack.push(curr.right);
            }

            // 3. Push Left child SECOND
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }

        return result;
    }
}