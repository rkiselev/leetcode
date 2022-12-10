package ru.leetcode.app.t1339;

import ru.leetcode.app.TreeNode;

public class MaximumProductOfSplittedBinaryTree {
    /**
     * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/
     * Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the
     * product of the sums of the subtrees is maximized.
     *
     * Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo
     * 10^9 + 7.
     *
     * Note that you need to maximize the answer before taking the mod and not after taking it.
     */
    class Solution {
        long result = 0;
        public int maxProduct(TreeNode root) {
            long sum = sum(root, 0L);
            sum(root, sum);
            return (int)(result%(1_000_000_007));
        }

        long sum(TreeNode root, long total) {
            if (root == null) return 0L;
            long sum = root.val + sum(root.left, total) + sum(root.right, total);
            result = Math.max(result, (total - sum)*sum);
            return sum;
        }
    }
}
