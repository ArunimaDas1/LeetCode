import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverseDirection = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                // Zigzag placement choice
                if (reverseDirection) {
                    currentLevel.addFirst(curr.val); // Add to front for right-to-left
                } else {
                    currentLevel.addLast(curr.val);  // Add to back for left-to-right
                }

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            result.add(currentLevel);
            reverseDirection = !reverseDirection; // Flip direction for the next level
        }

        return result;
    }
}