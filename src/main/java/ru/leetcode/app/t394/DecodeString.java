package ru.leetcode.app.t394;

import org.junit.Assert;

import java.util.Stack;

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
            Stack<Character> stack = new Stack<>();
            int index = 0;
            while(index < s.length()) {
                char c = s.charAt(index);
                if (c == ']') {
                    solveBracket(stack);
                } else {
                    stack.push(c);
                }
                index++;
            }
            StringBuilder result = new StringBuilder();
            while(!stack.isEmpty()) {
                result.append(stack.pop());
            }
            return result.reverse().toString();
        }

        private static void solveBracket(Stack<Character> stack) {
            StringBuilder semiResult = new StringBuilder();
            while(stack.peek() != '[') {
                semiResult.append(stack.pop());
            }
            stack.pop();
            StringBuilder number = new StringBuilder();
            while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                number.append(stack.pop());
            }
            String s = semiResult.reverse()
                    .toString()
                    .repeat(Math.max(0, Integer.parseInt(number.reverse().toString())));
            for (int i = 0; i < s.length(); i++) {
                stack.push(s.charAt(i));
            }
        }
}
