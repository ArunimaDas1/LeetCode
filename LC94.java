import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode IP = curr.left;

                // Loop until you reach the rightmost node of curr's left subtree
                while (IP.right != null && IP.right != curr) {
                    IP = IP.right;
                }

                if (IP.right == null) {
                    IP.right = curr; // Create temporary thread
                    curr = curr.left;
                } else {
                    IP.right = null; // Remove thread
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return ans;
    }
}