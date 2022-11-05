package ru.leetcode.app.t257;

import ru.leetcode.app.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinaryTreePaths {
    /**
     * https://leetcode.com/problems/binary-tree-paths/
     * Given the root of a binary tree, return all root-to-leaf paths in any order.
     *
     * A leaf is a node with no children.
     * Example 1:
     * Input: root = [1,2,3,null,5]
     * Output: ["1->2->5","1->3"]
     * Example 2:
     *
     * Input: root = [1]
     * Output: ["1"]
     */
    public static void main(String[] args) {

    }

    static class Solution {
        List<String> result = new ArrayList<>();
        public List<String> binaryTreePaths(TreeNode root) {
            buildPath(root, "");
            return result;
        }

        private void buildPath(TreeNode node, String path) {
            if (node == null) {
                return;
            }
            if (node.left == null && node.right == null) {
                path = path.concat(node.val + "");
                result.add(path);
                return;
            } else {
                path = path.concat(node.val + "->");
            }
            buildPath(node.left, path);
            buildPath(node.right, path);
        }
    }
}
