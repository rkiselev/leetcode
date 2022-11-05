package ru.leetcode.app.t297;

import ru.leetcode.app.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {
    /**
     * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
     *
     * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
     * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in
     * the same or another computer environment.
     *
     * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
     * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be
     * serialized to a string and this string can be deserialized to the original tree structure.
     *
     * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not
     * necessarily need to follow this format, so please be creative and come up with different approaches yourself.
     */

    public class Codec {
        List<String> values;
        int index;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            values = new ArrayList<>();
            writeTree(root);
            return String.join(",", values);
        }

        private void writeTree(TreeNode root) {
            if (root == null) {
                values.add("null");
                return;
            }
            values.add(String.valueOf(root.val));
            writeTree(root.left);
            writeTree(root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            index = 0;
            return readTree(data.split(","));
        }

        private TreeNode readTree(String[] arr) {
            if (arr[index].equals("null")) {
                index++;
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(arr[index++]));
            node.left = readTree(arr);
            node.right = readTree(arr);
            return node;
        }
    }
}
