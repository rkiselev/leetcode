package ru.leetcode.app.t110;

import ru.leetcode.app.TreeNode;

public class BalancedBinaryTree {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return calc(root).isBalanced;
        }

        private Balance calc(TreeNode node) {
            if (node == null) return new Balance(0, true);
            Balance left = calc(node.left);
            Balance right = calc(node.right);
            var isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1;
            return new Balance(1 + Math.max(left.height, right.height), isBalanced);
        }

        class Balance {
            int height;
            boolean isBalanced;
            Balance(int height, boolean isBalanced) {
                this.height = height;
                this.isBalanced = isBalanced;
            }
        }
    }
}
