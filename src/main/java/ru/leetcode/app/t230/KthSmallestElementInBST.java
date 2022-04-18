package ru.leetcode.app.t230;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {

    /**
     * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
     *
     * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of
     * all the values of the nodes in the tree.
     */
    List<Integer> array;
    public int kthSmallest(TreeNode root, int k) {
        array = new ArrayList<>();
        find(root, k, array);
        return array.get(k - 1);
    }

    private void find(TreeNode root, int k, List<Integer> array) {
        if (array.size() < k && root != null) {
            if (root.left != null) find(root.left, k, array);
            array.add(root.val);
            if (root.right != null) find(root.right, k, array);
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
