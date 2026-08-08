public class BinaryTreeBuilderin {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int[] preorder) {
            idx++;
            if (preorder[idx] == -1) {
                return null;
            }

            Node root = new Node(preorder[idx]);
            root.left = buildTree(preorder);
            root.right = buildTree(preorder);

            return root;
        }

        // Simple Inorder Traversal
        public static void inorder(Node root) {
            if (root == null) {
                return;
            }

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, -1, -1, 3, 4, -1, -1, 5, -1, -1};

        BinaryTree.idx = -1;
        Node root = BinaryTree.buildTree(preorder);

        System.out.print("Inorder: ");
        BinaryTree.inorder(root); // Output: 2 1 4 3 5
    }
}