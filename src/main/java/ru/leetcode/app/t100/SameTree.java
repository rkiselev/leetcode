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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        Queue<TreeNode> left = new ArrayDeque<>();
        left.add(p);
        Queue<TreeNode> right = new ArrayDeque<>();
        right.add(q);
        boolean result = true;

        while (!left.isEmpty() && !right.isEmpty() && result) {
            int n = left.size();
            for (int i = 0; i < n; i++) {
                TreeNode currentL = left.poll();
                TreeNode currentR = right.poll();
                if (currentL.val != currentR.val) {
                    result = false;
                } else {
                    if (currentL.left != null && currentR.left != null) {
                        left.add(currentL.left);
                        right.add(currentR.left);
                    } else if (!(currentL.left == null && currentR.left == null)) {
                        result = false;
                    }

                    if (currentL.right != null && currentR.right != null) {
                        left.add(currentL.right);
                        right.add(currentR.right);
                    } else if (!(currentL.right == null && currentR.right == null)) {
                        result = false;
                    }
                }
            }
        }

        return result;
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
