import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Inorder traversal to extract elements in sorted order
    public static void inorder(Node root, List<Integer> arr) {
        if (root == null) {
            return;
        }

        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }

    // Build balanced BST from sorted ArrayList
    public static Node buildBSTFromSorted(List<Integer> arr, int st, int end) {
        if (st > end) {
            return null;
        }

        int mid = st + (end - st) / 2;
        Node root = new Node(arr.get(mid));

        root.left = buildBSTFromSorted(arr, st, mid - 1);
        root.right = buildBSTFromSorted(arr, mid + 1, end);

        return root;
    }

    // Main Merge Function
    public static Node merge2BST(Node root1, Node root2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        // Step 1: Get sorted arrays from both BSTs
        inorder(root1, arr1);
        inorder(root2, arr2);

        // Step 2: Merge two sorted arrays
        List<Integer> temp = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                temp.add(arr1.get(i++));
            } else {
                temp.add(arr2.get(j++));
            }
        }

        while (i < arr1.size()) {
            temp.add(arr1.get(i++));
        }

        while (j < arr2.size()) {
            temp.add(arr2.get(j++));
        }

        // Step 3: Build balanced BST from merged sorted array
        return buildBSTFromSorted(temp, 0, temp.size() - 1);
    }
}