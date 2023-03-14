package ru.leetcode.app.t129;

import ru.leetcode.app.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SumRootToLeafNumbers {
    /**
     * https://leetcode.com/problems/sum-root-to-leaf-numbers/
     * <p>
     * You are given the root of a binary tree containing digits from 0 to 9 only.
     * <p>
     * Each root-to-leaf path in the tree represents a number.
     * <p>
     * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
     * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a
     * 32-bit integer.
     * <p>
     * A leaf node is a node with no children.
     */
    public static void main(String[] args) {
        TreeNode r = new TreeNode(0);
        TreeNode ll = new TreeNode(1);
        TreeNode l = new TreeNode(9, null, ll);
        TreeNode c = new TreeNode(4, l, r);
        assertEquals(531, new Solution().sumNumbers(c));
        int a = 2147483647;
    }

    static class Solution {
        List<String> numbers = new ArrayList<>();

        public int sumNumbers(TreeNode root) {
            int result = 0;
            if (root.left == null && root.right == null) return root.val;
            traverse(root, "");
            for (String s : numbers) {
                result += Integer.parseInt(s);
            }

            return result;
        }

        private void traverse(TreeNode root, String s) {
            if (root == null) {
                if (s.length() > 1) numbers.add(s);
                return;
            }
            if (root.left == null && root.right == null) {
                numbers.add(s + root.val);
                return;
            }

            if (root.left != null) traverse(root.left, s + root.val);
            if (root.right != null) traverse(root.right, s + root.val);
        }


    }
}
