package ru.leetcode.app.t3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.junit.Assert;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/
     *
     * Given a string s, find the length of the longest substring without repeating characters.
     */
    public static void main(String[] args) {
        Assert.assertEquals(3, lengthOfLongestSubstring("aabaab!bb"));

        Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));

        Assert.assertEquals(1, lengthOfLongestSubstring("bbbbb"));

        Assert.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }

    /**
     *the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values,
     * and keep two pointers which define the max substring. move the right pointer to scan through the string ,
     * and meanwhile update the hashmap. If the character is already in the hashmap, then move the left pointer to
     * the right of the same character last found. Note that the two pointers can only move forward.
     */

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int i = 0;
        var set = new HashSet<Character>();
        int start = 0;
        while (i < s.length()) {
            if (!set.add(s.charAt(i))) {
                result = Math.max(result, set.size());
                if (s.charAt(start) != s.charAt(i)) {
                    while (s.charAt(start) != s.charAt(i)) {
                        set.remove(s.charAt(start));
                        start++;
                    }
                }
                start++;
            }
            i++;
        }
        result = Math.max(result, set.size());
        return result;
    }
}
