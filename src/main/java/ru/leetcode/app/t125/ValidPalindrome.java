package ru.leetcode.app.t125;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidPalindrome {

    /**
     * https://leetcode.com/problems/valid-palindrome/
     *
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
     * all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include
     * letters and numbers.
     *
     * Given a string s, return true if it is a palindrome, or false otherwise.
     *
     * Example 1:
     *
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     * Example 2:
     *
     * Input: s = "race a car"
     * Output: false
     * Explanation: "raceacar" is not a palindrome.
     * Example 3:
     *
     * Input: s = " "
     * Output: true
     * Explanation: s is an empty string "" after removing non-alphanumeric characters.
     * Since an empty string reads the same forward and backward, it is a palindrome.
     */
    public static void main(String[] args) {
        assertTrue(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(new Solution().isPalindrome(" "));
        assertFalse(new Solution().isPalindrome("0P"));
        assertFalse(new Solution().isPalindrome("race a car"));
    }

    static class Solution {
        public boolean isPalindrome(String s) {
            boolean result = true;
            s = s.replace(" ", "").toLowerCase();
            int i = 0;
            int j = s.length() - 1;
            while(result && i <= j) {
                char first = s.charAt(i);
                char last = s.charAt(j);
                if (!(Character.isLetter(first) || Character.isDigit(first))) {
                    i++;
                    continue;
                }
                if (!(Character.isLetter(last) || Character.isDigit(last))) {
                    j--;
                    continue;
                }
                result = first == last;
                i++;
                j--;
            }

            return result;
        }
    }
}
