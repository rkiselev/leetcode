package ru.leetcode.app.t1379;

import ru.leetcode.app.TreeNode;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    /**
     * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
     *
     * Given two binary trees original and cloned and given a reference to a node target in the original tree.
     *
     * The cloned tree is a copy of the original tree.
     *
     * Return a reference to the same node in the cloned tree.
     *
     * Note that you are not allowed to change any of the two trees or the target node and the answer must be a
     * reference to a node in the cloned tree.
     */

    class Solution {
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            if (cloned == null) return cloned;

            if (cloned.val == target.val) return cloned;

            TreeNode l = getTargetCopy(original.left, cloned.left, target);
            TreeNode r = getTargetCopy(original.right, cloned.right, target);

            return l == null ? r : l;
        }
    }
}
