package ru.leetcode.app.t21;

public class MergeTwoSortedLists {

    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
     *
     * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
     * Return the linked list sorted as well.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 != null) {
            return list2;
        }
        if (list1 != null && list2 == null) {
            return list1;
        }
        if (list1 == null && list2 == null) {
            return null;
        }

        ListNode result = new ListNode();
        ListNode current = result;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                current.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                current.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            current = current.next;
        }
        if (list1 == null) {
            current.next = list2;
        } else if (list2 == null) {
            current.next = list1;
        }

        return result.next;
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
