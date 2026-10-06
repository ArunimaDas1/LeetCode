import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        // 1. Traversal in Root -> Right -> Left
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);

            // Push Left first, so Right gets processed first
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }

        // 2. Reverse (Root -> Right -> Left) to get (Left -> Right -> Root)
        Collections.reverse(result);

        return result;
    }
}