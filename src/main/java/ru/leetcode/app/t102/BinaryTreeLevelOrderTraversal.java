package ru.leetcode.app.t102;

import ru.leetcode.app.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            while(!q.isEmpty()) {
                int i = q.size();
                List<Integer> semiResult = new ArrayList<>();
                while(i != 0) {
                    var item = q.poll();
                    if (item != null) {
                        semiResult.add(item.val);
                        if (Objects.nonNull(item.left)) q.add(item.left);
                        if (Objects.nonNull(item.right)) q.add(item.right);
                    }
                    i--;

                }
                result.add(semiResult);
            }
            return result;
        }
    }
}
