package ru.leetcode.app.t700;

public class SearchInABinarySearchTree {

    /**
     * https://leetcode.com/problems/search-in-a-binary-search-tree/
     *
     * You are given the root of a binary search tree (BST) and an integer val.
     *
     * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
     * If such a node does not exist, return null.
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
        public TreeNode searchBST(TreeNode root, int val) {
            TreeNode result = null;
            var found = false;
            while (root != null && !found) {
                if (root.val == val) {
                    found = true;
                    result = root;
                } else if (val > root.val) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
            return result;
        }
    }
}
