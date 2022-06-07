package ru.leetcode.app.t1189;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MaximumNumberOfBalloons {
    /**
     * https://leetcode.com/problems/maximum-number-of-balloons/
     *
     * Given a string text, you want to use the characters of text to form as many instances of the word
     * "balloon" as possible.
     *
     * You can use each character in text at most once. Return the maximum number of instances that can be formed.
     *
     * Example 1:
     *
     * Input: text = "nlaebolko"
     * Output: 1
     * Example 2:
     *
     * Input: text = "loonbalxballpoon"
     * Output: 2
     * Example 3:
     *
     * Input: text = "leetcode"
     * Output: 0
     */
    public static void main(String[] args) {
        assertEquals(1, new Solution().maxNumberOfBalloons("nlaebolko"));
        assertEquals(2, new Solution().maxNumberOfBalloons("loonbalxballpoon"));
        assertEquals(0, new Solution().maxNumberOfBalloons("leetcode"));
    }

    static class Solution {
        public int maxNumberOfBalloons(String text) {
            var bal = toMap("balloon");
            var tMap = toMap(text);
            int result = Integer.MAX_VALUE;
            for (Map.Entry<Character, Integer> item: bal.entrySet()) {
                Integer textCount = tMap.getOrDefault(item.getKey(), 0);
                if (textCount == 0) return 0;
                result = Math.min(result, textCount / item.getValue());
            }
            return result;
        }

        private Map<Character, Integer> toMap(String s) {
            Map<Character, Integer> result = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char current = s.charAt(i);
                result.put(current, result.getOrDefault(current, 0) + 1);
            }
            return result;
        }
    }
}
