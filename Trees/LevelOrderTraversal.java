package Trees;

import java.util.*;

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


public class LevelOrderTraversal {

    static List<List<Integer>> traversal(Node head) {
        Queue<Node> queue = new LinkedList<Node>();
        List<List<Integer>> list = new ArrayList<>();

        if (head == null) {
            return list;
        }

        queue.offer(head);

        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }

                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }

                temp.add(queue.poll().data);
            }

            list.add(temp);
        }

        return list;
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(50);
        root.left.right = new Node(100);

        List<List<Integer>> ans = traversal(root);

        System.out.println(ans);
    }
}
