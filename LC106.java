import java.util.HashMap;
import java.util.Map;

class Solution {
    private int postIdx;
    private Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Postorder processes Root LAST, so we start from the back
        postIdx = postorder.length - 1;
        inMap.clear();

        // Map values to their indices in the inorder array
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int left, int right) {
        // Base Case: No elements left in this subtree range
        if (left > right) {
            return null;
        }

        // Pick current root from postorder (right-to-left)
        int rootVal = postorder[postIdx--];
        TreeNode root = new TreeNode(rootVal);

        // Find root's split index in the inorder array
        int inIdx = inMap.get(rootVal);

        // IMPORTANT: Must build RIGHT subtree BEFORE LEFT subtree 
        // because postorder processes nodes as [Left, Right, Root]
        root.right = helper(postorder, inIdx + 1, right);
        root.left = helper(postorder, left, inIdx - 1);

        return root;
    }
}