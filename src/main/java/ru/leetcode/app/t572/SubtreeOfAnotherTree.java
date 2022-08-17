package ru.leetcode.app.t572;

import ru.leetcode.app.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfAnotherTree {
    /**
     *  https://leetcode.com/problems/subtree-of-another-tree/
     *  Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the
     *  same structure and node values of subRoot and false otherwise.
     *
     * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
     * The tree tree could also be considered as a subtree of itself.
     */

    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            var result = false;
            if (root == null && subRoot == null) return true;
            if ((root != null && subRoot == null) || (root == null && subRoot != null)) return false;
            Queue<TreeNode> left = new LinkedList<>();
            left.add(root);
            while (!result && !left.isEmpty()) {
                int n = left.size();
                int i = 0;
                while (!result && i < n) {
                    var current = left.poll();
                    result = isSameTree(current, subRoot);
                    if (!result) {
                        if (current.left != null) left.add(current.left);
                        if (current.right != null) left.add(current.right);
                    }
                    i++;
                }
            }
            return result;
        }

        public boolean isSameTree(TreeNode l, TreeNode r) {
            if (l == null && r == null) return true;
            if (l == null || r == null) return false;
            if (l.val != r.val) return false;
            boolean left = isSameTree(l.left, r.left);
            boolean right = isSameTree(l.right, r.right);
            return right && left;
        }
    }
}
