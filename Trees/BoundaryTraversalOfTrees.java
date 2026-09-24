package Trees;
import java.util.ArrayList;

/** 
    Approach:

    1. First, write a function to check whether a node is a leaf node.

    2. Left Boundary:
    - Traverse from the root's left child.
    - Add nodes that are NOT leaf nodes.
    - If left child exists, move left; otherwise move right.

    3. Leaf Nodes:
    - Traverse the entire tree.
    - Add only leaf nodes from left to right.

    4. Right Boundary:
    - Traverse from the root's right child.
    - Add nodes that are NOT leaf nodes.
    - Store them separately and add them in reverse order
        because the right boundary is required bottom-to-top.

    Time Complexity: O(N)
    Space Complexity: O(H)
 */

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

public class BoundaryTraversalOfTrees {
    
    static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    static void addLeftBoundary(Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        Node current = root.left;

        while (current != null) {
            if (!isLeaf(current)) {
                ans.add(current.data);
            }

            if (current.left != null) {
                current = current.left;
            }else{
                current = current.right;
            }
        }
    }

    static void addLeaves(Node root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            ans.add(root.data);
            return;
        }

        addLeaves(root.left, ans);
        addLeaves(root.right, ans);
    }

    static void addRightBoundary(Node root, ArrayList<Integer> ans) {

        ArrayList<Integer> temp = new ArrayList<>();

        Node current = root.right;

        while (current != null) {
            if (!isLeaf(current)) {
                temp.add(current.data);
            }

            if (current.right != null) {
                current = current.right;
            }else{
                current = current.left;
            }
        }

        for (int i = temp.size() - 1; i >= 0; i--) {
            ans.add(temp.get(i));
        }
    }

    static ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        if (!isLeaf(root)) {
            ans.add(root.data);
        }

        addLeftBoundary(root, ans);

        addLeaves(root, ans);

        addRightBoundary(root, ans);

        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(50);
        root.left.right = new Node(100);

        System.out.println(boundaryTraversal(root));
    }

}
