package ru.leetcode.app.t872;

import ru.leetcode.app.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeafSimilarTrees {
    /**
     * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf
     * value sequence.
     *
     * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
     *
     * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
     *
     * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
     *
     * Example 1:
     *
     * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
     * Output: true
     * Example 2:
     *
     * Input: root1 = [1,2,3], root2 = [1,3,2]
     * Output: false
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {


        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            getLeafs(root1, left);
            getLeafs(root2, right);
            if (left.size() != right.size()) {
                System.out.println("size different");
                return false;
            }
            for (int i = 0; i < left.size(); i++) {
                if (!Objects.equals(left.get(i), right.get(i))) return false;
            }
            return true;
        }

        private void getLeafs(TreeNode root, List<Integer> l) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                l.add(root.val);
                return;
            }
            getLeafs(root.left, l);
            getLeafs(root.right, l);
        }
    }
}
