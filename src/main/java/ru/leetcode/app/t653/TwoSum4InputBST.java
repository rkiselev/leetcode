package ru.leetcode.app.t653;

import ru.leetcode.app.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TwoSum4InputBST {
    /**
     * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
     *
     * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the
     * BST such that their sum is equal to the given target.
     */

    public static void main(String[] args) {
        var t = new TreeNode(2);
        var t1 = new TreeNode(4);
        var t2 = new TreeNode(3, t, t1);
        var t3 = new TreeNode(7);
        var t4 = new TreeNode(6, null, t3);
        var t5 = new TreeNode(5, t2, t4);
        new Solution().findTarget(t5, 9);

    }

    static class Solution {
        List<Integer> values;
        public boolean findTarget(TreeNode root, int k) {
            values = new ArrayList<>();
            fill(root);
            int start = 0;
            int end = values.size() - 1;
            boolean found = false;
            while (start != end && !found) {
                int sum = values.get(start) + values.get(end);
                if (sum == k) {
                    found = true;
                } else if (sum < k) {
                    start++;
                } else {
                    end--;
                }
            }
            return found;
        }

        private void fill(TreeNode root) {
            if (root == null) return;
            fill(root.left);
            values.add(root.val);
            fill(root.right);
        }
    }
}
