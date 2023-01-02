package ru.leetcode.app.t24;

import ru.leetcode.app.ListNode;
import ru.leetcode.app.hack.LinkedListArr;

public class SwapNodesInPairs {
    /**
     * https://leetcode.com/problems/swap-nodes-in-pairs/
     *
     * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without
     * modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
     */
    public static void main(String[] args) {
        new Solution().swapPairs(LinkedListArr.convert(new int[]{1,2,3,4}));
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode prev = new ListNode(0);
            prev.next = head;
            ListNode current = prev;
            while(prev != null && prev.next != null && prev.next.next != null) {
                var back = prev.next;
                var nextBack = back.next;
                back.next = nextBack.next;
                nextBack.next = back;
                prev.next = nextBack;

                prev = prev.next.next;
            }
            return current.next;
        }
    }
}
