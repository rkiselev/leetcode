package ru.leetcode.app.t958;

import ru.leetcode.app.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertTrue;

public class CheckCompletenessBinaryTree {
    /**
     * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
     *
     * Given the root of a binary tree, determine if it is a complete binary tree.
     *
     * In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the
     * last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
     */

    public static void main(String[] args) {
        var ll = new TreeNode(4);
        var lr = new TreeNode(5);
        var rl = new TreeNode(6);
        var l = new TreeNode(2, ll, lr);
        var r = new TreeNode(3, rl, null);
        var c = new TreeNode(1, l, r);
        assertTrue(new Solution().isCompleteTree(c));
    }

    static class Solution {
        public boolean isCompleteTree(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(q.peek() != null) {
                var curr = q.poll();
                q.add(curr.left);
                q.add(curr.right);
            }
            while (!q.isEmpty()) {
                var curr = q.poll();
                if(curr != null) return false;
            }

            return true;
        }
    }
}
