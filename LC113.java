import java.util.ArrayList;
import java.util.List;

class Solution {

    private void findpath(TreeNode root, int targetSum, List<Integer> array, List<List<Integer>> result) {
        if (root == null) return;

        // 1. Choose: Add current node value to path FIRST
        array.add(root.val);

        // 2. Leaf check: If leaf node and sum matches
        if (root.left == null && root.right == null && targetSum == root.val) {
            result.add(new ArrayList<>(array));
        } else {
            // Recurse left and right with remaining sum
            int remSum = targetSum - root.val;
            findpath(root.left, remSum, array, result);
            findpath(root.right, remSum, array, result);
        }

        // 3. Backtrack: Remove current node before returning up
        array.remove(array.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        findpath(root, targetSum, array, result);
        return result;
    }
}