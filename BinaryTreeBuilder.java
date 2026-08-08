public class BinaryTreeBuilder {

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

    static class BinaryTree { // Fixed lowercase 'static'
        static int idx = -1;

        // Fixed return type and added 'static' so BinaryTree.buildTree(...) works
        public static Node buildTree(int[] preorder) { 
            idx++;
            
            if (preorder[idx] == -1) {
                return null; // Fixed lowercase 'null'
            }

            Node root = new Node(preorder[idx]);
            root.left = buildTree(preorder);  
            root.right = buildTree(preorder); 

            return root;
        }
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, -1, -1, 3, 4, -1, -1, 5, -1, -1};
        
        BinaryTree.idx = -1; 
        
        Node root = BinaryTree.buildTree(preorder);

        System.out.println("Root node value: " + root.data); // Output: Root node value: 1
    }
}