package ru.leetcode.app.hack;

public class LinkedListArr {

    public static void main(String[] args) {
        var r = convert(new int[]{1,2,3,4,5});
        System.out.println(r);
    }

    private static Node convert(int[] arr) {
        Node result = new Node();
        Node backup = result;

        for(int v: arr) {
            backup.next = new Node(v);
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
