package Trees;


class Node{
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BalancedBinaryTree {

    /**
     * Approach 1:
     * Calculate the height of the left and right subtrees.
     * If the difference is greater than 1, return false.
     * Otherwise, recursively check both subtrees.
     *
     * TC - O(N^2) worst case
     * SC - O(H), O(N) worst case
     */

    static boolean isBalanced1(Node root) {

        if(root == null) {
            return true;
        }
        
        int leftHeight = height1(root.left);
        int rightHeight = height1(root.right);
        
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        
        return isBalanced1(root.left) && isBalanced1(root.right);
    }  
    
    static int height1(Node root) {
        if(root == null) {
            return 0;
        }
        
        int leftHeight = height1(root.left);
        int rightHeight = height1(root.right);
        
        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Approach 2:
     * Calculate the height of the left and right subtrees.
     * If any subtree is unbalanced, return -1.
     * If the current node is unbalanced, return -1.
     * Otherwise, return the height of the current subtree.
     *
     * TC - O(N)
     * SC - O(H), O(N) worst case
     */
    
    static boolean isBalanced(Node root) {
        return height(root) != -1;
    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(50);
        root.left.right = new Node(100);

        System.out.println(isBalanced(root));
    }
}
