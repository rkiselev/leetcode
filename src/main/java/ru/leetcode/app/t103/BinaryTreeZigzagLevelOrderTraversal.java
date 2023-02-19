package ru.leetcode.app.t103;

import ru.leetcode.app.TreeNode;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
     * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from
     * left to right, then right to left for the next level and alternate between).
     */
    public static void main(String[] args) {
        TreeNode v1 = new TreeNode(15);
        TreeNode v2 = new TreeNode(7);
        TreeNode v3 = new TreeNode(20, v1, v2);
        TreeNode v4 = new TreeNode(9);
        TreeNode v5 = new TreeNode(3, v4, v3);
        assertEquals(List.of(List.of(3), List.of(20,9), List.of(15,7)), new Solution().zigzagLevelOrder(v5));
    }

    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            int odd = 0;
            while(!q.isEmpty()) {
                List<Integer>semiresult = new ArrayList<>();
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    var current = q.poll();
                    semiresult.add(current.val);
                    if (current.left != null) q.add(current.left);
                    if (current.right != null) q.add(current.right);
                }
                if (odd % 2 != 0) Collections.reverse(semiresult);
                result.add(semiresult);
                odd++;
            }
            return result;
        }
    }
}
