class Solution {
    private int preIdx = 0;

    private int search(int[] inorder, int left, int right, int target) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private TreeNode helper(int[] preorder, int[] inorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootVal = preorder[preIdx];
        TreeNode root = new TreeNode(rootVal);
        preIdx++;

        int inIdx = search(inorder, left, right, rootVal);

        root.left = helper(preorder, inorder, left, inIdx - 1);
        root.right = helper(preorder, inorder, inIdx + 1, right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0;
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
}