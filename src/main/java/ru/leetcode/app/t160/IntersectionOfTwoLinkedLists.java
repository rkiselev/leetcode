package ru.leetcode.app.t160;

import ru.leetcode.app.ListNode;

public class IntersectionOfTwoLinkedLists {
    /**
     * https://leetcode.com/problems/intersection-of-two-linked-lists/
     *
     * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
     * If the two linked lists have no intersection at all, return null.
     *
     * For example, the following two linked lists begin to intersect at node c1:
     * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
     *
     * Note that the linked lists must retain their original structure after the function returns.
     *
     * Custom Judge:
     *
     * The inputs to the judge are given as follows (your program is not given these inputs):
     *
     * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
     * listA - The first linked list.
     * listB - The second linked list.
     * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
     * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
     * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB
     * to your program. If you correctly return the intersected node, then your solution will be accepted.
     */

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int first = getSize(headA);
            int second = getSize(headB);
            if(first > second) {
                headA = move(first - second, headA);
            } else {
                headB = move(second - first, headB);
            }
            boolean same = false;
            while(!same && headA != null) {
                same = (headA == headB);
                if (!same) {
                    headA = headA.next;
                    headB = headB.next;
                }
            }
            return same ? headA : null;
        }

        private ListNode move(int step, ListNode item) {
            while(step != 0) {
                item = item.next;
                step--;
            }
            return item;
        }

        private int getSize(ListNode item) {
            int size = 0;
            ListNode current = item;
            while(current != null) {
                current = current.next;
                size++;
            }
            return size;
        }
    }
}
