package ru.leetcode.app.t105;

import ru.leetcode.app.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        new Solution().buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 1) return new TreeNode(preorder[0]);
            List<Integer> pre = Arrays.stream(preorder).boxed().collect(Collectors.toList());
            List<Integer> in = Arrays.stream(inorder).boxed().collect(Collectors.toList());
            var result = constructTree(pre, in);

            return result;
        }

        private TreeNode constructTree(List<Integer> pre, List<Integer> in) {
            if (in.size() == 1) return new TreeNode(in.get(0));
            if (pre.size() == 0 || in.size() == 0) return null;
            Integer root = pre.get(0);
            int index = in.indexOf(root);
            var preRight = new ArrayList<>(pre.subList(1, pre.size()));
            preRight.removeAll(in.subList(0, index));
            return new TreeNode(
                    root,
                    constructTree(pre.subList(1, pre.size()), in.subList(0, index)),
                    constructTree(preRight, in.subList(index + 1, in.size()))
            );
        }

        Map<Integer, Integer> inorderPositions = new HashMap<>();

        public TreeNode buildTree2(int[] preorder, int[] inorder) {
            if (preorder.length < 1 || inorder.length < 1) return null;

            for (int i = 0; i < inorder.length; i++) {
                inorderPositions.put(inorder[i], i);
            }

            return builder(preorder, 0, 0, inorder.length - 1);
        }

        public TreeNode builder(int[] preorder, int preorderIndex, int inorderLow, int inorderHigh) {
            if (preorderIndex > preorder.length - 1 || inorderLow > inorderHigh) return null;

            int currentVal = preorder[preorderIndex];
            TreeNode n = new TreeNode(currentVal);
            int mid = inorderPositions.get(currentVal);

            n.left = builder(preorder, preorderIndex + 1, inorderLow, mid - 1);
            n.right = builder(preorder, preorderIndex + (mid - inorderLow) + 1, mid + 1, inorderHigh);

            return n;
        }
    }


}
