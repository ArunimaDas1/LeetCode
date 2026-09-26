class Solution {
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        
        // Step 1: Inorder traversals
        inorder(root1, arr1);
        inorder(root2, arr2);
        
        // Step 2: Two-pointer merge
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                result.add(arr1.get(i++));
            } else {
                result.add(arr2.get(j++));
            }
        }
        
        while (i < arr1.size()) result.add(arr1.get(i++));
        while (j < arr2.size()) result.add(arr2.get(j++));
        
        return result; // Done! No BST reconstruction needed.
    }
}