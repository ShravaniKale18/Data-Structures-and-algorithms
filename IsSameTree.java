import java.util.*;

class IsSameTree {

     /**
     * Approach 1: Preorder Traversal + ArrayList
     *
     * - Perform preorder traversal (Root -> Left -> Right) on both trees.
     * - Store the values of both trees in separate ArrayLists.
     * - Compare the sizes of both lists.
     * - If sizes are different, trees are not same.
     * - Compare corresponding elements of both lists.
     *
     * Note:
     * This approach checks only node values and does NOT preserve
     * the tree structure when null nodes are not stored.
     *
     * TC: O(n)
     * SC: O(n)
     */

    static boolean isSameTree1(TreeNode p, TreeNode q) {

        ArrayList<Integer> listP = new ArrayList<>();
        ArrayList<Integer> listQ = new ArrayList<>();

        preOrderTraversal(p, listP);
        preOrderTraversal(q, listQ);

        if (listP.size() != listQ.size()) {
            return false;
        }

        for (int i = 0; i < listP.size(); i++) {
            if (!listP.get(i).equals(listQ.get(i))) {
                return false;
            }
        }

        return true;
    }

    static void preOrderTraversal(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);

        preOrderTraversal(node.left, list);
        preOrderTraversal(node.right, list);
    }

     /**
     * Approach 2: Recursive Comparison
     *
     * - Compare both trees node by node.
     * - If both nodes are null, they are same.
     * - If one node is null, structures are different.
     * - If node values are different, trees are different.
     * - Recursively compare the left subtrees.
     * - Recursively compare the right subtrees.
     * - Both left and right subtrees must be same.
     *
     * TC: O(n)
     * SC: O(h)
     *
     * where h = height of the tree.
     */

    static boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null) {
            return false;
        }

        if(p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }

    public static void main(String[] args) {
    
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        // p.left.right = new TreeNode(4);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(isSameTree(p, q)); 
    }
}