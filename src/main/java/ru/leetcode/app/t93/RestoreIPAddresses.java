package ru.leetcode.app.t93;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    /**
     * https://leetcode.com/problems/restore-ip-addresses/
     *
     * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255
     * (inclusive) and cannot have leading zeros.
     *
     * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and
     * "192.168@1.1" are invalid IP addresses.
     * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting
     * dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses
     * in any order.
     *
     * Example 1:
     *
     * Input: s = "25525511135"
     * Output: ["255.255.11.135","255.255.111.35"]
     * Example 2:
     *
     * Input: s = "0000"
     * Output: ["0.0.0.0"]
     * Example 3:
     *
     * Input: s = "101023"
     * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
     */
    public static void main(String[] args) {
        new Solution().restoreIpAddresses("25525511135");
    }

    static class Solution {
        List<String> result;
        public List<String> restoreIpAddresses(String s) {
            result = new ArrayList<>();
            if (s.length() > 12) return result;
            traverse(s, 0, "",0);

            return result;
        }

        private void traverse(String s, int i, String semiresult, int dotCount) {
            if (i == s.length() || dotCount >= 3) {
                if (i == s.length() && dotCount == 3) {
                    result.add(semiresult.substring(0, semiresult.length() - 1));
                }
                return;
            }
            int sizeDigit = 1;
            traverse(s, i + sizeDigit, semiresult + s.substring(i, i + sizeDigit) + ".", dotCount + 1);
            sizeDigit++;
            if (i + sizeDigit > s.length()) return;
            String number = s.substring(i, i + sizeDigit);
            if (number.startsWith("0")) return;
            traverse(s, i + sizeDigit, semiresult + number + ".", dotCount + 1);
            sizeDigit++;
            if (i + sizeDigit > s.length()) return;
            number = s.substring(i, i + sizeDigit);
            if (Integer.parseInt(number) > 255) return;
            traverse(s, i + sizeDigit, semiresult + number + ".", dotCount + 1);
        }
    }

}
