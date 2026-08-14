import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeZigZagLevelOrderTraversal {

    /*
     * Approach:
     * 1. Use a Queue to perform Level Order Traversal (BFS).
     * 2. Process one level at a time using the current queue size.
     * 3. Store all nodes of the current level in a temporary list.
     * 4. If the current direction is Right-to-Left, reverse the list.
     * 5. Add the processed level to the final answer.
     * 6. Toggle the traversal direction after every level.
     *
     * Time Complexity:
     * O(N)
     * - Every node is visited exactly once.
     * - Reversing each level collectively takes O(N) in the worst case.
     *
     * Space Complexity:
     * O(N)
     * - Queue stores at most one level of nodes.
     * - Output list stores all N nodes.
     * - Temporary level list also uses space proportional to the level size.
     */

    static List<List<Integer>> zigzagLevelOrder(Node root) {

        // Edge case: If tree is empty, return empty list.
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        // false -> Left to Right
        // true  -> Right to Left
        boolean leftToRight = false;

        queue.offer(root);

        while (!queue.isEmpty()) {

            List<Integer> ans = new ArrayList<>();

            // Number of nodes present at current level
            int s = queue.size();

            for (int i = 0; i < s; i++) {

                Node node = queue.poll(); //returns the current node 
                ans.add(node.data); //add it into the ans list

                // Add left child
                if (node.left != null) {
                    queue.offer(node.left);
                }

                // Add right child
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Reverse current level for zigzag order
            if (leftToRight) {
                Collections.reverse(ans);
            }

            // Change direction for next level
            leftToRight = !leftToRight;

            list.add(ans);
        }

        return list;
    }

    public static void main(String[] args) {
        Node root =  new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        System.out.println(zigzagLevelOrder(root));

    }
}