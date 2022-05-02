package ru.leetcode.app.t14;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        assertEquals("fl", new Solution().longestCommonPrefix(new String[]{"flower","flow","flight"}));
        assertEquals("", new Solution().longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder result = new StringBuilder();
            int index = 0;
            int minLength = Arrays.stream(strs).map(String::length).mapToInt(it -> it).min().orElse(-1);
            boolean same = true;
            while(index < minLength && same) {
                same = true;
                for(int i = 1; i < strs.length; i++) {
                    if (strs[0].charAt(index) != strs[i].charAt(index)) {
                        same = false;
                        break;
                    }
                }
                if (same) result.append(strs[0].charAt(index));
                index++;

            }

            return result.toString();
        }
    }
}
