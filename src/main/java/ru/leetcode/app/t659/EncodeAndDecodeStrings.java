package ru.leetcode.app.t659;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    /**
     * Description
     * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network
     * and is decoded back to the original list of strings.
     *
     * Please implement encode and decode
     *
     * Example
     * Example1
     *
     * Input: ["lint","code","love","you"]
     * Output: ["lint","code","love","you"]
     * Explanation:
     * One possible encode method is: "lint:;code:;love:;you"
     * Example2
     *
     * Input: ["we", "say", ":", "yes"]
     * Output: ["we", "say", ":", "yes"]
     * Explanation:
     * One possible encode method is: "we:;say:;:::;yes"
     */
    public class Solution {
        /*
         * @param strs: a list of strings
         * @return: encodes a list of strings to a single string.
         */
        public String encode(List<String> strs) {
            StringBuilder builder = new StringBuilder();
            for(String s: strs) {
                builder.append(s.length())
                        .append("#")
                        .append(s);
            }
            return builder.toString();
            // write your code here
        }

        /*
         * @param str: A string
         * @return: dcodes a single string to a list of strings
         */
        public List<String> decode(String str) {
            var result = new ArrayList<String>();
            int id = str.indexOf("#");
            while(id > 0) {
                int length = Integer.parseInt(str.substring(0, id));
                result.add(str.substring(id + 1, id + 1 + length));
                str = str.substring(id + 1 + length);
                System.out.println(str);
                id = str.indexOf("#");
            }

            return result;
            // write your code here
        }
    }
}
