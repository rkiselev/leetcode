package ru.leetcode.app.t652;

import ru.leetcode.app.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    /**
     * https://leetcode.com/problems/find-duplicate-subtrees/description/
     * Given the root of a binary tree, return all duplicate subtrees.
     * <p>
     * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
     * <p>
     * Two trees are duplicate if they have the same structure with the same node values.
     */

    class Solution {
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            Map<String, Integer> map = new HashMap<>();
            List<TreeNode> result = new ArrayList();
            traverse(root, map, result);

            return result;
        }

        private String traverse(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
            if (root == null) return "null";
            var left = traverse(root.left, map, result);
            var right = traverse(root.right, map, result);
            String s = root.val + "," + left + "," + right;
            if (map.getOrDefault(s, 0) == 1) {
                result.add(root);
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
            return s;
        }


    }


}
