package ru.leetcode.app.t1209;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjacentDuplicatesInStringII {
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
