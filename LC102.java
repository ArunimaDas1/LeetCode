class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        // LinkedList MUST be used because ArrayDeque throws NPE on queue.add(null)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); // Level 0 delimiter

        List<Integer> currentLevel = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr == null) {
                // END OF LEVEL DETECTED
                result.add(new ArrayList<>(currentLevel));
                currentLevel.clear();

                // Re-insert null marker if there are nodes left for the next level
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                currentLevel.add(curr.val);

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }

        return result;
    }
}