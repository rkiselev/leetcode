package ru.leetcode.app.t394;

import org.junit.Assert;

public class DecodeString {

    /**
     * https://leetcode.com/problems/decode-string/
     *
     * Given an encoded string, return its decoded string.
     *
     * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
     * exactly k times. Note that k is guaranteed to be a positive integer.
     *
     * You may assume that the input string is always valid; there are no extra white spaces, square brackets are
     * well-formed, etc.
     *
     * Furthermore, you may assume that the original data does not contain any digits and that digits are only for
     * those repeat numbers, k. For example, there will not be input like 3a or 2[4].
     */
    public static void main(String[] args) {
        String s = decodeString("3[a]2[bc]");
        Assert.assertEquals("aaabcbc", s);

        s = decodeString("3[a2[c]]");
        Assert.assertEquals("accaccacc", s);

        s = decodeString("2[abc]3[cd]ef");
        Assert.assertEquals("abcabccdcdcdef", s);
    }

    public static String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length())  {
            i = decode(s, i, result);
        }


        return result.toString();
    }

    private static int decode(String s, int current, StringBuilder result) {
        int i = current;
        char c;
        do{
            c = s.charAt(i);
            if(Character.isLetter(c)) {
                result.append(c);
            } else if(Character.isDigit(c)) {
                StringBuilder count = new StringBuilder();
                StringBuilder value = new StringBuilder();
                while(c !='[') {
                    count.append(c);
                    i++;
                    c = s.charAt(i);
                }
                i++;
                c = s.charAt(i);
                while(c !=']') {
                    if (Character.isDigit(c)) {
                        StringBuilder r = new StringBuilder();
                        i = decode(s, i, r);
                        value.append(r);
                    } else {
                        value.append(c);
                        i++;
                    }
                    c = s.charAt(i);
                }
                var countI = Integer.valueOf(count.toString());
                for (int j = 0; j < countI; j++) {
                    result.append(value);
                }
            }
            i++;
        } while(i < s.length() && c !=']');
        return i;
    }
}
