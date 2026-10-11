import java.util.HashMap;
import java.util.Map;

class Solution {
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1); // blank 1: Base case. A prefix sum of 0 has occurred 1 time.
        dfs(root, 0L, targetSum, map);
        return count;
    }

    private void dfs(TreeNode node, long curr, int target, Map<Long, Integer> map) {
        if (node == null) return;

        curr += node.val;
        
        // blank 2: We look for a previous prefix sum equal to (curr - target)
        count += map.getOrDefault(curr - target, 0); 
        
        // Record current prefix sum in map before going deeper
        map.put(curr, map.getOrDefault(curr, 0) + 1);

        dfs(node.left, curr, target, map);
        dfs(node.right, curr, target, map);

        // blank 3: Backtrack! Remove current prefix sum when leaving the node
        map.put(curr, map.get(curr) - 1);
    }
}