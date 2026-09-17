import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // Helper pair class to hold a node along with its positional index
    private static class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            long minIdx = queue.peek().index; // Minimum index at current level
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node;
                // Subtract minIdx to normalize index and prevent integer overflow
                long curIdx = current.index - minIdx;

                if (i == 0) first = curIdx;
                if (i == size - 1) last = curIdx;

                // Push children with scaled indices
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * curIdx + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * curIdx + 2));
                }
            }

            // Calculate width for current level
            maxWidth = Math.max(maxWidth, (int) (last - first + 1));
        }

        return maxWidth;
    }
}