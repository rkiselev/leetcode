package ru.leetcode.app.t199;

import ru.leetcode.app.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    /**
     * https://leetcode.com/problems/binary-tree-right-side-view/
     *
     * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the
     * nodes you can see ordered from top to bottom.
     */

    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                var current = q.poll();
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
                if (i == size - 1) result.add(current.val);
            }
        }
        return result;
    }
}
