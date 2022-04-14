package ru.leetcode.app.t234;

public class PalindromeLinkedList {

    /**
     * https://leetcode.com/problems/palindrome-linked-list/
     * <p>
     * Given the head of a singly linked list, return true if it is a palindrome.
     */
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode middle = middle(head);
        ListNode reverse = reverse(middle);

        boolean same = true;
        while (same && reverse != null) {
            same = reverse.val == head.val;
            reverse = reverse.next;
            head = head.next;
        }

        return same;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private ListNode middle(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
