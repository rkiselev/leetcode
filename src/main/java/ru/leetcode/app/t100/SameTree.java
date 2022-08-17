package ru.leetcode.app.t100;

import java.util.ArrayDeque;
import java.util.Queue;

public class SameTree {

    /**
     * https://leetcode.com/problems/same-tree/
     * <p>
     * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
     * <p>
     * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
     */

    public boolean isSameTree(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        if (l.val != r.val) return false;
        boolean left = isSameTree(l.left, r.left);
        boolean right = isSameTree(l.right, r.right);
        return right && left;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
