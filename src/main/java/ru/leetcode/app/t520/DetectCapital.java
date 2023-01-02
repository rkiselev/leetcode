package ru.leetcode.app.t520;

import org.junit.Assert;

public class DetectCapital {
    /**
     * https://leetcode.com/problems/detect-capital/description/
     * We define the usage of capitals in a word to be right when one of the following cases holds:
     *
     * All letters in this word are capitals, like "USA".
     * All letters in this word are not capitals, like "leetcode".
     * Only the first letter in this word is capital, like "Google".
     * Given a string word, return true if the usage of capitals in it is right.
     */
    public static void main(String[] args) {
        Assert.assertTrue(new Solution().detectCapitalUse("USA"));
        Assert.assertTrue(new Solution().detectCapitalUse("leetcode"));
        Assert.assertTrue(new Solution().detectCapitalUse("Google"));
        Assert.assertFalse(new Solution().detectCapitalUse("FlaG"));
    }

    static class Solution {
        public boolean detectCapitalUse(String word) {
            boolean allUp = true;
            boolean allLow = true;
            boolean firstUp = true;
            int i = 0;
            while(i < word.length() && (allUp || allLow || firstUp)) {
                char c = word.charAt(i);
                firstUp &= isFirst(i, c);
                allUp &= Character.isUpperCase(c);
                allLow &= Character.isLowerCase(c);
                i++;
            }
            return allUp || allLow || firstUp;
        }

        private boolean isFirst(int index, char c) {
            return (index == 0 && Character.isUpperCase(c)) ||
                    (index > 0 && Character.isLowerCase(c));
        }
    }
}
