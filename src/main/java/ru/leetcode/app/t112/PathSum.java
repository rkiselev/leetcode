package ru.leetcode.app.t112;

public class PathSum {

    /**
     * https://leetcode.com/problems/path-sum/
     *
     * <p>
     * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path
     * such that adding up all the values along the path equals targetSum.
     * <p>
     * A leaf is a node with no children.
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
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
