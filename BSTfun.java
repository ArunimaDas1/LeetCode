import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    // ==========================================
    // 1. INSERTION (Recursive) - O(H) Time
    // ==========================================
    public void insert(int val) {
        root = insertRecursive(root, val);
    }

    private TreeNode insertRecursive(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (val < node.val) {
            node.left = insertRecursive(node.left, val);
        } else if (val > node.val) {
            node.right = insertRecursive(node.right, val);
        }
        // Duplicate values are ignored in standard BSTs

        return node;
    }

    // ==========================================
    // 2. SEARCH - O(H) Time
    // ==========================================
    public boolean search(int val) {
        return searchRecursive(root, val);
    }

    private boolean searchRecursive(TreeNode node, int val) {
        if (node == null) return false;
        if (node.val == val) return true;

        if (val < node.val) {
            return searchRecursive(node.left, val);
        } else {
            return searchRecursive(node.right, val);
        }
    }

    // ==========================================
    // 3. MINIMUM & MAXIMUM VALUE - O(H) Time
    // ==========================================
    public int findMin() {
        if (root == null) throw new IllegalStateException("Tree is empty");
        return findMinNode(root).val;
    }

    private TreeNode findMinNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int findMax() {
        if (root == null) throw new IllegalStateException("Tree is empty");
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr.val;
    }

    // ==========================================
    // 4. DELETION - O(H) Time
    // ==========================================
    public void delete(int val) {
        root = deleteRecursive(root, val);
    }

    private TreeNode deleteRecursive(TreeNode node, int val) {
        if (node == null) return null;

        if (val < node.val) {
            node.left = deleteRecursive(node.left, val);
        } else if (val > node.val) {
            node.right = deleteRecursive(node.right, val);
        } else {
            // Node to delete found!

            // Case 1: Leaf node (no children) or Case 2: One child
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Case 3: Two children
            // Find Inorder Successor (smallest in right subtree)
            TreeNode successor = findMinNode(node.right);
            node.val = successor.val; // Replace value
            node.right = deleteRecursive(node.right, successor.val); // Delete successor
        }

        return node;
    }

    // ==========================================
    // 5. TRAVERSALS - O(N) Time
    // ==========================================
    // Inorder (Left -> Root -> Right) - Yields Sorted Array
    public List<Integer> inorder() {
        List<Integer> res = new ArrayList<>();
        inorderHelper(root, res);
        return res;
    }

    private void inorderHelper(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inorderHelper(node.left, res);
        res.add(node.val);
        inorderHelper(node.right, res);
    }

    // Level Order (BFS)
    public List<Integer> levelOrder() {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            res.add(curr.val);

            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }

        return res;
    }

    // ==========================================
    // 6. VALIDATE BST (LeetCode 98 logic) - O(N) Time
    // ==========================================
    public boolean isValidBST() {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return validate(node.left, min, node.val) && 
               validate(node.right, node.val, max);
    }
}