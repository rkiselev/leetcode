package ru.leetcode.app.t1740;

import ru.leetcode.app.TreeNode;

import static org.junit.Assert.assertEquals;

public class FindDistanceInABinaryTree {
    /**
     * Given the root of a binary tree and two integers p and q, return the distance between the nodes of value p and
     * value q in the tree.
     *
     * The distance between two nodes is the number of edges on the path from one to the other.
     *
     * Example 1:
     *
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 0
     * Output: 3
     * Explanation: There are 3 edges between 5 and 0: 5-3-1-0.
     *
     * Example 2:
     *
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 7
     * Output: 2
     * Explanation: There are 2 edges between 5 and 7: 5-2-7.
     *
     * Example 3:
     *
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 5
     * Output: 0
     * Explanation: The distance between a node and itself is 0.
     */
    public static void main(String[] args) {
        var t1 = new TreeNode(0);
        var t2 = new TreeNode(3);
        var t3 = new TreeNode(5);
        var t4 = new TreeNode(7);
        var t5 = new TreeNode(9);
        var t6 = new TreeNode(4, t2, t3);
        var t7 = new TreeNode(8, t4, t5);
        var t8 = new TreeNode(2, t1, t6);
        var t9 = new TreeNode(6, t8, t7);
        assertEquals(2, distance(t9, t8,t7));

    }

    static int distance(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode parent = getParent(root, p, q);
        return  distance(parent, p) + distance(parent, q);
    }

    static private int distance(TreeNode root, TreeNode p) {
        if (root == null) return -1;
        if (root.val == p.val) return 0;
        int left = distance(root.left, p);
        int right = distance(root.right, p);
        if (left == -1 && right == -1) return -1;
        return (1 + Math.max(right, left));
    }

    static private TreeNode getParent(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if (root.val > q.val && root.val > p.val) {
                root = root.left;
            } else if (root.val < q.val && root.val < p.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
