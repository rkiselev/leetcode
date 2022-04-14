package ru.leetcode.app.t543;

public class DiameterOfBinaryTree {

    /**
     * https://leetcode.com/problems/diameter-of-binary-tree/
     *
     * <p>
     * Given the root of a binary tree, return the length of the diameter of the tree.
     * <p>
     * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
     * This path may or may not pass through the root.
     * <p>
     * The length of a path between two nodes is represented by the number of edges between them.
     */
    class Solution {
        int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            maxDepth(root);
            return max;
        }

        private int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            max = Math.max(max, left + right);

            return Math.max(left, right) + 1;
        }
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
