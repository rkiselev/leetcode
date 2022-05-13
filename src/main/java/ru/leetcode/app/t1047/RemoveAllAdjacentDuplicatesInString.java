package ru.leetcode.app.t1047;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

public class RemoveAllAdjacentDuplicatesInString {

    /**
     * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
     *
     * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing
     * two adjacent and equal letters and removing them.
     *
     * We repeatedly make duplicate removals on s until we no longer can.
     *
     * Return the final string after all such duplicate removals have been made. It can be proven that
     * the answer is unique.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abbaca"
     * Output: "ca"
     * Explanation:
     * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the
     * only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible,
     * so the final string is "ca".
     * Example 2:
     *
     * Input: s = "azxxzy"
     * Output: "ay"
     */

    public static void main(String[] args) {
        assertEquals("", new Solution().removeDuplicates(""));
        assertEquals("ca", new Solution().removeDuplicates("abbaca"));
        assertEquals("ay", new Solution().removeDuplicates("azxxzy"));
        var i = new ArrayList<Pair>();
        i.sort(Comparator.comparingInt(a -> a.value));
    }

    class Pair {
        int index;
        int value;
        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }


    }

    static class Solution {
        public String removeDuplicates(String s) {

            Deque<Character> q = new ArrayDeque<>();
            for(int i = 0; i < s.length(); i++) {
                if (!q.isEmpty() && q.peek() == s.charAt(i)) {
                    q.poll();
                } else {
                    q.push(s.charAt(i));
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!q.isEmpty()) {
                sb.append(q.pollLast());
            }
            return sb.toString();

        }
    }
}
