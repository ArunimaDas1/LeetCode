import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null); // Marker for the end of level 0

        LinkedList<Integer> currentLevel = new LinkedList<>();
        boolean reverseDirection = false;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            // Have we hit the level boundary marker?
            if (curr == null) {
                result.add(currentLevel);
                currentLevel = new LinkedList<>(); // Reset for next level
                reverseDirection = !reverseDirection; // Toggle direction

                // If the queue isn't empty, it means lower-level nodes are waiting, 
                // so we drop a new null marker for the end of this next level!
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else {
                // Normal node processing (same as before!)
                if (reverseDirection) {
                    currentLevel.addFirst(curr.val);
                } else {
                    currentLevel.addLast(curr.val);
                }

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }

        return result;
    }
}