import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    // Custom pair class to track node and its level-relative positional index
    private static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Deque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIdx = queue.peek().index; // Offset to prevent integer overflow
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node;
                int curIdx = current.index - minIdx; // Normalized index

                if (i == 0) first = curIdx;
                if (i == size - 1) last = curIdx;

                // Left child gets 2 * index, Right child gets 2 * index + 1
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * curIdx));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * curIdx + 1));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}