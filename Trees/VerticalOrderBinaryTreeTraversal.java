package Trees;
import java.util.*;

/** 
 * Approach:
 * 1. We will use a TreeMap to store the nodes in vertical order.
 * 2. The key of the TreeMap will be the column index,
 *    and the value will be another TreeMap that stores the row index and a priority queue of node values.
 * 3. We will perform a level order traversal of the tree using a queue, and for each node, 
 *    we will add its value to the appropriate position in the TreeMap based on its row and column indices.
 * 4. Finally, we will iterate through the TreeMap to construct the result list of lists.
 * 5. The priority queue ensures that if multiple nodes have the same row and column indices,
 *    they will be sorted in ascending order.
 
 * Time Complexity: O(N log N), where N is the number of nodes in the tree.
 * Space Complexity: O(N), where N is the number of nodes in the tree. 
 */

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

class Tuple {
    Node node;
    int row;
    int col;

    Tuple(Node node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class VerticalOrderBinaryTreeTraversal {

    public static List<List<Integer>> verticalTraversal(Node root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> queue = new LinkedList<>();

        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {

            Tuple t = queue.poll();

            Node node = t.node;
            int row = t.row;
            int col = t.col;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());

            map.get(col).get(row).offer(node.val);

            if (node.left != null) {
                queue.offer(new Tuple(node.left, row + 1, col - 1));
            }

            if (node.right != null) {
                queue.offer(new Tuple(node.right, row + 1, col + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows
                : map.values()) {

            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> nodes : rows.values()) {
                while (!nodes.isEmpty()) {
                    column.add(nodes.poll());
                }
            }

            ans.add(column);
        }

        return ans;
    }

    public static void main(String[] args) {

        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);


        System.out.println(verticalTraversal(root));
    }
}
