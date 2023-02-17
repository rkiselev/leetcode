package ru.leetcode.app.t783;

import ru.leetcode.app.TreeNode;

import static org.junit.Assert.assertEquals;

public class MinimumDistanceBetweenBSTNodes {
    /**
     * https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
     *
     * Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any
     * two different nodes in the tree.
     */
    public static void main(String[] args) {
        TreeNode v1 = new TreeNode(12);
        TreeNode v2 = new TreeNode(49);
        TreeNode v3 = new TreeNode(48, v1, v2);
        TreeNode v4 = new TreeNode(0);
        TreeNode v5 = new TreeNode(1, v4, v3);


        assertEquals(1, new Solution().minDiffInBST(v5));
    }

    static class Solution {
        int result = Integer.MAX_VALUE;
        TreeNode prev = null;
        public int minDiffInBST(TreeNode root) {
            calc(root);
            return result;
        }

        private void calc(TreeNode root) {
            if (root == null) return;
            if (root.left != null) calc(root.left);
            if (prev != null) result = Math.min(result, root.val - prev.val);
            prev = root;
            if (root.right != null) {
                calc(root.right);
            }
        }
    }
}
