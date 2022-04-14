package ru.leetcode.app.t111;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    /**
     * https://leetcode.com/problems/minimum-depth-of-binary-tree/
     *
     * <p>
     * Given a binary tree, find its minimum depth.
     * <p>
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest
     * leaf node.
     * <p>
     * Note: A leaf is a node with no children.
     */

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;
        boolean found = false;
        while (!found) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode current = queue.poll();
                if (current.left == null && current.right == null) {
                    found = true;
                }
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
