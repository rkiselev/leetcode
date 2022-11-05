package ru.leetcode.app.t449;

import ru.leetcode.app.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeBST {
    /**
     * https://leetcode.com/problems/serialize-and-deserialize-bst/
     */

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     *
     * Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a
     * file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or
     * another computer environment.
     *
     * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your
     * serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be
     * serialized to a string, and this string can be deserialized to the original tree structure.
     *
     * The encoded string should be as compact as possible.
     */
    public class Codec {
        List<String> values;
        int index;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            values = new ArrayList<>();
            writeValue(root);
            System.out.println(String.join(",", values));
            return String.join(",", values);
        }

        private void writeValue(TreeNode root) {
            if (root == null) {
                values.add("null");
                return;
            }
            values.add(String.valueOf(root.val));
            writeValue(root.left);
            writeValue(root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] arr = data.split(",");
            index = 0;
            return readData(arr);
        }

        private TreeNode readData(String[] arr) {
            if (arr[index].equals("null")) {
                index++;
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(arr[index]));
            index++;
            node.left = readData(arr);
            node.right = readData(arr);
            return node;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
}
