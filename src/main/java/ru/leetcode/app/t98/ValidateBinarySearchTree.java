package ru.leetcode.app.t98;

import ru.leetcode.app.TreeNode;

public class ValidateBinarySearchTree {
    /**
     * https://leetcode.com/problems/validate-binary-search-tree/
     *
     * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
     *
     * A valid BST is defined as follows:
     *
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     */

    class Solution {
        boolean result = true;
        public boolean isValidBST(TreeNode root) {
            if (root == null) return result;
            result = check(root, null, null);
            return result;
        }
        private boolean check(TreeNode root, Integer left, Integer right) {
            if (root == null) return true;

            if ((right != null && root.val >= right) || (left != null && root.val <= left)) return false;

            return check(root.left, left, root.val) && check(root.right, root.val, right);
        }
    }


}
