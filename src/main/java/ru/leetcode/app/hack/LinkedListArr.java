package ru.leetcode.app.hack;

import ru.leetcode.app.ListNode;

public class LinkedListArr {

    public static void main(String[] args) {
        var r = convert(new int[]{1,2,3,4,5});
        System.out.println(r);
    }

    public static ListNode convert(int[] arr) {
        ListNode result = new ListNode();
        ListNode backup = result;

        for(int v: arr) {
            backup.next = new ListNode(v);
            backup = backup.next;
        }
        return result.next;

    }

    static class Node {

        int val;
        Node next;

        public Node() {
            val = 0;
            next = null;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
