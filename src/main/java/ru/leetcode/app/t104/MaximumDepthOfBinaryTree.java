package ru.leetcode.app.t104;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    /**
     *
     * https://leetcode.com/problems/maximum-depth-of-binary-tree/
     *
     * Given the root of a binary tree, return its maximum depth.
     *
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to
     * the farthest leaf node.
     */

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

    class Solution {
        public int maxDepth(TreeNode root) {
            int depth = 0;
            if (root == null) {
                return depth;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    TreeNode current = queue.poll();
                    if (current.left != null) {
                        queue.add(current.left);
                    }
                    if (current.right != null) {
                        queue.add(current.right);
                    }
                }
                depth++;
            }

            return depth;

        }
    }
}
