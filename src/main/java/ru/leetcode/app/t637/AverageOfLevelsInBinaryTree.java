package ru.leetcode.app.t637;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    /**
     * https://leetcode.com/problems/average-of-levels-in-binary-tree/
     *
     * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
     * Answers within 10-5 of the actual answer will be accepted.
     */
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Double> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0.0d;
            for (int i = 0; i < size; i++) {
                var current = queue.poll();
                sum += current.val;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            result.add(sum/size);
        }

        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
