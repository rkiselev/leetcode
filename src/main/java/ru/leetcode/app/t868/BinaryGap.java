package ru.leetcode.app.t868;

import static org.junit.Assert.assertEquals;

public class BinaryGap {
    /**
     *
     * https://leetcode.com/problems/binary-gap/
     *
     * Given a positive integer n, find and return the longest distance between any two adjacent 1's in the binary
     * representation of n. If there are no two adjacent 1's, return 0.
     *
     * Two 1's are adjacent if there are only 0's separating them (possibly no 0's). The distance between two 1's is
     * the absolute difference between their bit positions. For example, the two 1's in "1001" have a distance of 3.
     *
     *
     * Example 1:
     *
     * Input: n = 22
     * Output: 2
     * Explanation: 22 in binary is "10110".
     * The first adjacent pair of 1's is "10110" with a distance of 2.
     * The second adjacent pair of 1's is "10110" with a distance of 1.
     * The answer is the largest of these two distances, which is 2.
     * Note that "10110" is not a valid pair since there is a 1 separating the two 1's underlined.
     * Example 2:
     *
     * Input: n = 8
     * Output: 0
     * Explanation: 8 in binary is "1000".
     * There are not any adjacent pairs of 1's in the binary representation of 8, so we return 0.
     * Example 3:
     *
     * Input: n = 5
     * Output: 2
     * Explanation: 5 in binary is "101".
     */

    public static void main(String[] args) {
        assertEquals(1,new Solution().binaryGap(6));
        assertEquals(2,new Solution().binaryGap(5));
        assertEquals(0,new Solution().binaryGap(8));
    }

    static class Solution {
        public int binaryGap(int n) {
            int result = 0;
            int semiResult = 0;
            var binary = Integer.toBinaryString(n);
            char prev = binary.charAt(0);
            int i = 1;
            boolean started = false;
            while (i < binary.length()) {
                char current = binary.charAt(i);
                if (started) {
                    if (current == '0') {
                        semiResult++;
                    } else {
                        result = Math.max(result, semiResult);
                        semiResult = 0;
                        started = false;
                    }
                } else if (prev == '1' && current == '0') {
                    semiResult += 2;
                    started = true;
                } else if (prev == '1' && current == '1') {
                    result = Math.max(result, 1);
                }
                prev = current;
                i++;
            }
            return result;
        }
    }
}
