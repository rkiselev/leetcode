package t20;

import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParentheses {
    public static void main(String[] args) {
        assertTrue(new Solution().isValid("()"));
        assertTrue(new Solution().isValid("()[]{}"));
        assertFalse(new Solution().isValid("(]"));
    }

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            List<Character> close = List.of(')','}', ']');
            for(char ch: s.toCharArray()) {
                if (close.contains(ch)) {
                    if (stack.isEmpty() || (!isClose(stack.pop(), ch))) {
                        return false;
                    }
                } else {
                    stack.push(ch);
                }
            }
            return stack.isEmpty();
        }

        boolean isClose(char first, char second) {
            switch (first) {
                case '{': return second == '}';
                case '[': return second == ']';
                case '(': return second == ')';
                default: return false;
            }
        }
    }
}
