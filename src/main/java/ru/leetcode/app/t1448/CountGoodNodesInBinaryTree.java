package ru.leetcode.app.t1448;

import ru.leetcode.app.TreeNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CountGoodNodesInBinaryTree {
    /**
     * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
     *
     * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes
     * with a value greater than X.
     *
     * Return the number of good nodes in the binary tree.
     */

    public static void main(String[] args) {
        TreeNode i = new TreeNode(3, null, null);
        TreeNode j = new TreeNode(1, i, null);
        TreeNode a = new TreeNode(1, null, null);
        TreeNode b = new TreeNode(5, null, null);
        TreeNode c = new TreeNode(4, a, b);


        TreeNode root = new TreeNode(3, j, c);

        int result = new Solution().goodNodes(root);
        assertEquals(4, result);
    }

    static class Solution {
        int result = 0;
        public int goodNodes(TreeNode root) {
            count(root, Integer.MIN_VALUE);
            return result;
        }

        private void count(TreeNode root, int maxValue) {
            if (root == null) return;
            if (root.val >= maxValue) {
                result++;
                count(root.left, root.val);
                count(root.right, root.val);
            } else {
                count(root.left, maxValue);
                count(root.right, maxValue);
            }
        }
    }
}
