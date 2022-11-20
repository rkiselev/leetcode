package ru.leetcode.app.t23;

import ru.leetcode.app.ListNode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    /**
     * https://leetcode.com/problems/merge-k-sorted-lists/
     * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
     *
     * Merge all the linked-lists into one sorted linked-list and return it.
     *
     *
     *
     * Example 1:
     *
     * Input: lists = [[1,4,5],[1,3,4],[2,6]]
     * Output: [1,1,2,3,4,4,5,6]
     * Explanation: The linked-lists are:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * merging them into one sorted list:
     * 1->1->2->3->4->4->5->6
     */
    public static void main(String[] args) {
        ListNode l3 = new ListNode(5);
        ListNode l2 = new ListNode(4, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode l6 = new ListNode(4);
        ListNode l5 = new ListNode(3, l6);
        ListNode l4 = new ListNode(1, l5);

        ListNode l8 = new ListNode(6);
        ListNode l7 = new ListNode(2, l8);

        var r = new Solution().mergeKLists(new ListNode[]{l1,l4,l7});
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            Queue<ListNode> q = new ArrayDeque<>();
            for(int i = 0; i < lists.length; i++) {
                if (lists[i] != null) q.add(lists[i]);
            }
            while(q.size() > 1 ) {
                q.add(merge(q.poll(), q.poll()));
            }
            return q.peek();
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            if(l2 == null) return l1;
            if (l1 == null) return l2;
            ListNode result = new ListNode(0);
            var curr = result;
            while(l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    curr.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    curr.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                curr = curr.next;
            }
            if (l1 == null) {
                curr.next = l2;
            } else {
                curr.next = l1;
            }

            return result.next;
        }

        public ListNode mergeKLists2(ListNode[] lists) {
            Queue<Integer> q = new PriorityQueue<>();
            for(int i = 0; i < lists.length; i++) {
                var curr = lists[i];
                while(curr != null) {
                    q.add(curr.val);
                    curr = curr.next;
                }
            }
            ListNode result = new ListNode(0);
            var curr = result;
            while(!q.isEmpty()) {
                curr.next = new ListNode(q.poll());
                curr = curr.next;
            }
            return result.next;
        }
    }
}
