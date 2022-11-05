package ru.leetcode.app.t101;

import ru.leetcode.app.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertTrue;

public class SymmetricTree {
    /**
     * https://leetcode.com/problems/symmetric-tree/
     *
     * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
     */

    public static void main(String[] args) {
        var tree = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(3),
                        new TreeNode(4)
                ),
                new TreeNode(
                        2,
                        new TreeNode(4),
                        new TreeNode(3)
                )
        );
        assertTrue(new Solution().isSymmetric(tree));
    }

    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            return isSymmetricCycle(root.left, root.right);
        }

        private boolean isSymmetricCycle(TreeNode first, TreeNode second) {
            boolean result = true;
            Queue<TreeNode> q1 = new LinkedList<>();
            Queue<TreeNode> q2 = new LinkedList<>();
            q1.add(first);
            q2.add(second);
            while(result && !q1.isEmpty()) {
                int size = q1.size();
                for (int i = 0; i < size; i++) {
                    var v1 = q1.poll();
                    var v2 = q2.poll();
                    result = v1.val == v2.val;
                    if (v1.left != null && v2.right != null) {
                        q1.add(v1.left);
                        q2.add(v2.right);
                    } else if ((v1.left == null && v2.right != null) || (v1.left != null && v2.right == null)){
                        result = false;
                    }
                    if (v2.left != null && v1.right != null) {
                        q2.add(v2.left);
                        q1.add(v1.right);
                    } else if ((v2.left == null && v1.right != null) || (v2.left != null && v1.right == null)){
                        result = false;
                    }
                }
            }
            return result;
        }

        private boolean isSymmetric(TreeNode first, TreeNode second) {
            if (first == null && second == null) return true;
            if (first != null && second != null && first.val == second.val) {
                return isSymmetric(first.left, second.left) && isSymmetric(first.right, second.right);
            }
            return false;
        }
    }
}
