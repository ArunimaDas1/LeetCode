import java.util.ArrayList;
import java.util.List;

class Solution {
    private void allPaths(TreeNode root, String path, List<String> ans) {
        // Base Case: Leaf node reached
        if (root.left == null && root.right == null) {
            ans.add(path);
            return;
        }

        // Move to left child
        if (root.left != null) {
            allPaths(root.left, path + "->" + root.left.val, ans);
        }

        // Move to right child
        if (root.right != null) {
            allPaths(root.right, path + "->" + root.right.val, ans);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        String path = String.valueOf(root.val);
        allPaths(root, path, ans);

        return ans;
    }
}