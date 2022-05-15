package ru.leetcode.app.t1302;

import ru.leetcode.app.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Queue;

public class DeepestLeavesSum {
    /**
     * https://leetcode.com/problems/deepest-leaves-sum/
     *  Given the root of a binary tree, return the sum of values of its deepest leaves.
     */

    class Solution {
        public int deepestLeavesSum(TreeNode root) {
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            var list = new ArrayList<TreeNode>();
            while(!q.isEmpty()) {
                list = new ArrayList<>();
                int n  = q.size();
                for (int i = 0; i < n; i++) {
                    var current = q.poll();
                    list.add(current);
                    if (current.left != null) q.add(current.left);
                    if (current.right != null) q.add(current.right);
                }
            }
            return list.stream().filter(Objects::nonNull).mapToInt(it -> it.val).sum();
        }
    }
}
