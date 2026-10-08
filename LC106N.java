import java.util.HashMap;
import java.util.Map;

class Solution {
    private int postIdx;
    private Map<Integer, Integer> inMap;

    private TreeNode helper(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }

        // Pick current root from postorder end
        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);
        postIdx--; // Move backwards in postorder array

        int inIdx = inMap.get(rootVal);

        // MUST build RIGHT subtree first, then LEFT subtree!
        root.right = helper(postorder, inIdx + 1, right);
        root.left = helper(postorder, left, inIdx - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;
        inMap = new HashMap<>();

        // Store inorder indices for O(1) lookup
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1);
    }
}