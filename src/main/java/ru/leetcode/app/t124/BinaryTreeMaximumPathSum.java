package ru.leetcode.app.t124;

import ru.leetcode.app.TreeNode;

public class BinaryTreeMaximumPathSum {
    /**
     * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
     *
     * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge
     * connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass
     * through the root.
     *
     * The path sum of a path is the sum of the node's values in the path.
     *
     * Given the root of a binary tree, return the maximum path sum of any non-empty path.
     */
    public static void main(String[] args) {

    }

    class Solution {
        int result = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            calcMaxPath(root);
            return result;
        }

        private int calcMaxPath(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) {
                result = Math.max(result, root.val);
                return root.val;
            }
            int left = Math.max(0, calcMaxPath(root.left));
            int right = Math.max(0, calcMaxPath(root.right));
            result = Math.max(result, root.val + left + right);
            return root.val + Math.max(left, right);
        }
    }
}
