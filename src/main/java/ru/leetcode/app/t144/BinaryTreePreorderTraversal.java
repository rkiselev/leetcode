package ru.leetcode.app.t144;

import ru.leetcode.app.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    /**
     * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
     * Given the root of a binary tree, return the preorder traversal of its nodes' values.
     *
     * Example 1:
     *
     * Input: root = [1,null,2,3]
     * Output: [1,2,3]
     *
     * Example 2:
     * Input: root = []
     * Output: []
     *
     * Example 3:
     * Input: root = [1]
     * Output: [1]
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [0, 100].
     * -100 <= Node.val <= 100
     *
     *
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     */

    class Solution {
        List<Integer> result;
        public List<Integer> preorderTraversal(TreeNode root) {
            result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            if (root != null)stack.add(root);
            while(!stack.isEmpty()) {
                var v = stack.pop();
                result.add(v.val);
                if (v.right != null) stack.add(v.right);
                if (v.left != null) stack.add(v.left);
            }
            //traverse(root);
            return result;
        }

        private void traverse(TreeNode root) {
            if (root == null) return;
            result.add(root.val);
            traverse(root.left);
            traverse(root.right);
        }
    }
}
