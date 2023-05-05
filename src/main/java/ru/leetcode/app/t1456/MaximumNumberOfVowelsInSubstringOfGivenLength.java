package ru.leetcode.app.t1456;

import static org.junit.Assert.assertEquals;

public class MaximumNumberOfVowelsInSubstringOfGivenLength {
    /**
     * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
     * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
     *
     * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abciiidef", k = 3
     * Output: 3
     * Explanation: The substring "iii" contains 3 vowel letters.
     * Example 2:
     *
     * Input: s = "aeiou", k = 2
     * Output: 2
     * Explanation: Any substring of length 2 contains 2 vowels.
     * Example 3:
     *
     * Input: s = "leetcode", k = 3
     * Output: 2
     * Explanation: "lee", "eet" and "ode" contain 2 vowels.
     */
    public static void main(String[] args) {
        assertEquals(4, new Solution().maxVowels("weallloveyou", 7));
    }

    static class Solution {
        public int maxVowels(String s, int k) {
            int start = 0;
            int end = 0;
            int result = 0;
            int currentResult = 0;
            for (int i = end; i < k; i++) {
                if (isVowel(s.charAt(i))) currentResult++;
            }
            end = k;
            result = Math.max(result, currentResult);
            while(end < s.length()) {
                if (isVowel(s.charAt(start++))) currentResult--;
                if (isVowel(s.charAt(end))) currentResult++;

                end++;
                result = Math.max(result, currentResult);
            }
            return result;
        }

        public boolean isVowel(char c) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
            return false;
        }
    }
}


