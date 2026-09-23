package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Approach:
 *
 * - Use BFS (Level Order Traversal) using a Queue.
 * - Process the tree level by level.
 * - Store all nodes of the current level in a list.
 * - Traverse the first level from left to right.
 * - Reverse the next level to get right to left traversal.
 * - Continue changing the direction after every level.
 *
 * TC - O(N)
 * SC - O(N)
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

public class ZigZagLevelOrderTraversal {

    static ArrayList<ArrayList<Integer>> zigzagLevelOrder(Node root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        if (root == null) {
            return result;
        }

        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                level.add(current.data);

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            if (!leftToRight) {
                Collections.reverse(level);
            }

            result.add(level);

            leftToRight = !leftToRight;
        }

        return result;
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(50);
        root.left.right = new Node(100);

        System.out.println(zigzagLevelOrder(root));
    }
}
