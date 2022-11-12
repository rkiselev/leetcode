package ru.leetcode.app.t557;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseWordsInStringIII {
    /**
     * https://leetcode.com/problems/reverse-words-in-a-string-iii/
     * Given a string s, reverse the order of characters in each word within a sentence while still preserving
     * whitespace and initial word order.
     *
     * Example 1:
     *
     * Input: s = "Let's take LeetCode contest"
     * Output: "s'teL ekat edoCteeL tsetnoc"
     * Example 2:
     *
     * Input: s = "God Ding"
     * Output: "doG gniD"
     */
    public static void main(String[] args) {
        new Solution().reverseWords("Let's take LeetCode contest");
    }

    static class Solution {
        public String reverseWords(String s) {
            List<String> result = new ArrayList<>();
            for (String word: s.split(" ")) {
                result.add(revert(word));
            }
            return String.join(" ", result);
        }

        private String revert(String s) {
            int first = 0;
            int last = s.length() - 1;
            char[] result = new char[s.length()];
            while(first <= last) {
                result[first] = s.charAt(last);
                result[last] = s.charAt(first);
                first++;
                last--;
            }

            return new String(result);
        }
    }
}
