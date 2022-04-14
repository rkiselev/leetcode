package ru.leetcode.app.t203;

public class RemoveLinkedListElements {

    /**
     * https://leetcode.com/problems/remove-linked-list-elements/
     * <p>
     * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has
     * Node.val == val, and return the new head.
     */
    public static void main(String[] args) {

    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(1);
        result.next = head;
        ListNode current = result;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return result.next;
    }

    public static class ListNode {
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
