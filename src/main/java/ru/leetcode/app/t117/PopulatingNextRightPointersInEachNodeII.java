package ru.leetcode.app.t117;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
    /**
     * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
     *
     * Given a binary tree
     *
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer
     * should be set to NULL.
     *
     * Initially, all next pointers are set to NULL.
     */


    class Solution {
        public Node connect(Node root) {
            if (root == null) return null;
            Queue<Node> q = new ArrayDeque<>();
            q.add(root);
            while(!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    var current = q.poll();
                    if (i < size - 1) current.next = q.peek();
                    if (current.left != null) q.add(current.left);
                    if (current.right != null) q.add(current.right);
                }
            }

            return root;

        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
