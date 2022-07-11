package ru.leetcode.app.t19;

import ru.leetcode.app.ListNode;

public class RemoveNthNodeFromEndofList {
    /**
     * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
     * Given the head of a linked list, remove the nth node from the end of the list and return its head.
     *
     * Example 1:
     *
     * Input: head = [1,2,3,4,5], n = 2
     * Output: [1,2,3,5]
     * Example 2:
     *
     * Input: head = [1], n = 1
     * Output: []
     * Example 3:
     *
     * Input: head = [1,2], n = 1
     * Output: [1]
     */

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || head.next == null) return null;
            ListNode temp = new ListNode(0, head);
            ListNode left = temp;
            ListNode right = head;
            int i = 0;
            while(i != n) {
                i++;
                right = right.next;
            }
            while(right != null) {
                left = left.next;
                right = right.next;
            }
            left.next = left.next.next;
            return temp.next;
        }
    }

}
