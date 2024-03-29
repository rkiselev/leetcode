package ru.leetcode.app.t1026;

import ru.leetcode.app.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor {
    /**
     * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/
     * Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b
     * where v = |a.val - b.val| and a is an ancestor of b.
     *
     * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
     */

    class Solution {
        private int result = 0;
        public int maxAncestorDiff(TreeNode root) {
            calc(root, root.val, root.val);
            return result;
        }

        private void calc(TreeNode root, int min, int max) {
            if (root == null) return;

            result = Math.max(result, Math.abs(min - root.val));
            result = Math.max(result, Math.abs(max - root.val));

            min = Math.min(min, root.val);
            max = Math.max(max, root.val);

            calc(root.left, min, max);
            calc(root.right, min, max);

        }
    }
}
