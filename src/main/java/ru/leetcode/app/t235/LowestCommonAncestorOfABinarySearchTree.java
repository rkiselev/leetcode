package ru.leetcode.app.t235;

public class LowestCommonAncestorOfABinarySearchTree {

    /**
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
     * <p>
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
     * <p>
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two
     * nodes p and q as the lowest node in T that has both p and q as descendants
     * (where we allow a node to be a descendant of itself).”
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            boolean found = false;
            while (!found) {
                if (root.val < p.val && root.val < q.val) {
                    root = root.right;
                } else if (root.val > p.val && root.val > q.val) {
                    root = root.left;
                } else {
                    found = true;
                }
            }
            return root;
        }
    }
}
