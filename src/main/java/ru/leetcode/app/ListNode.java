package ru.leetcode.app;

public class ListNode {
      public int val;
      public ListNode next;

      public ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
      ListNode(int x) {
          val = x;
          next = null;
      }
}