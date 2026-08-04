/**
* Approach:

    * 1. Recursively find the maximum path sum from the left and right subtrees.
    * 2. Ignore negative path sums using Math.max(0, path).
    * 3. For the current node, calculate the path passing through it:
    * 4. Update the global maximum.
    * 5. Return the current node value plus the maximum of the left or right path,
    * because a parent node can extend the path through only one side.
    *
    * TC => O(N)
    * SC => O(H), where H is the height of the tree.
    *
    * For a skewed tree: O(N)
    * For a balanced tree: O(log N)
*/

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTreeMaximumPathSum {


    static int maximum = Integer.MIN_VALUE;

    static int maxPathSum(Node root) {

        maximum = Integer.MIN_VALUE;
        maxPath(root);

        return maximum;
    }

    static int maxPath(Node root) {

        if (root == null) {
            return 0;
        }

        int lh = Math.max(0, maxPath(root.left));
        int rh = Math.max(0, maxPath(root.right));

        // Path passing through the current node
        maximum = Math.max(maximum, lh + rh + root.data);

        // Return only one side to the parent
        return root.data + Math.max(lh, rh);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        System.out.println(maxPathSum(root));
    }
}
