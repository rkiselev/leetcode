package ru.leetcode.app.t306;

import static org.junit.Assert.*;

public class AdditiveNumber {
    /**
     *
     */
    public static void main(String[] args) {
        assertTrue(new Solution().isAdditiveNumber("112"));
        assertFalse(new Solution().isAdditiveNumber("11"));
        assertTrue(new Solution().isAdditiveNumber("112358"));
    }

    static class Solution {
        public boolean isAdditiveNumber(String num) {
            for(int i = 1; i < num.length(); i++) {
                String semiFirst = num.substring(0, i);
                if (semiFirst.length() > 1 && semiFirst.startsWith("0")) continue;
                long first = Long.parseLong(semiFirst);
                String rest = num.substring(i);
                for (int j = 1; j < rest.length(); j++) {
                    String semiSecond = rest.substring(0, j);
                    if (semiSecond.length() > 1 && semiSecond.startsWith("0")) continue;
                    long second = Long.parseLong(semiSecond);
                    var third = rest.substring(j);
                    if (third.length() == 0) continue;
                    if (isValidSequence(first, second, third)) return true;
                }
            }
            return false;
        }

        private boolean isValidSequence(Long first, Long second, String third) {
            if (third.length() == 0) return true;
            String sum = String.valueOf(first + second);
            if (third.startsWith(sum)) {
                return isValidSequence(second, Long.parseLong(sum), third.replaceFirst(sum,""));
            } else {
                return false;
            }
        }
    }
}
