package ru.leetcode.app.t946;

import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidateStackSequences {
    /**
     *
     */
    public static void main(String[] args) {
        assertTrue(new Solution().validateStackSequences(new int[]{2,1,0}, new int[]{1,2,0}));
        assertTrue(new Solution().validateStackSequences(new int[]{1,0}, new int[]{0,1}));
        assertFalse(new Solution().validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
        assertTrue(new Solution().validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
    }

    static class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int i = 0;
            for (int item: pushed) {
                stack.push(item);
                while (i < popped.length && !stack.isEmpty() && stack.peek() == popped[i]) {
                    i++;
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }
    }
}


