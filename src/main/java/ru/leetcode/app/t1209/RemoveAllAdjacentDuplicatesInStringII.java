package ru.leetcode.app.t1209;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjacentDuplicatesInStringII {

    /**
     * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
     *
     * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal
     * letters from s and removing them, causing the left and the right side of the deleted substring to concatenate
     * together.
     *
     * We repeatedly make k duplicate removals on s until we no longer can.
     *
     * Return the final string after all such duplicate removals have been made. It is guaranteed that the answer
     * is unique.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abcd", k = 2
     * Output: "abcd"
     * Explanation: There's nothing to delete.
     * Example 2:
     *
     * Input: s = "deeedbbcccbdaa", k = 3
     * Output: "aa"
     * Explanation:
     * First delete "eee" and "ccc", get "ddbbbdaa"
     * Then delete "bbb", get "dddaa"
     * Finally delete "ddd", get "aa"
     * Example 3:
     *
     * Input: s = "pbbcggttciiippooaais", k = 2
     * Output: "ps"
     */
    public static void main(String[] args) {
        var s = new Solution().removeDuplicates("aacaacb", 2);
    }

    static class Solution {
        static class Pair {
            char c;
            int count = 1;

            public Pair(char c) {
                this.c = c;
            }
        }

        public String removeDuplicates(String s, int k) {
            Deque<Pair> stack = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && (stack.peek().c == c)) {
                    Pair p = stack.peek();
                    p.count++;
                    if (p.count >= k) {
                        stack.pop();
                    }
                } else {
                    stack.push(new Pair(c));
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                Pair p = stack.pollLast();
                sb.append(String.valueOf(p.c).repeat(p.count));
            }
            return sb.toString();
        }
    }
}
