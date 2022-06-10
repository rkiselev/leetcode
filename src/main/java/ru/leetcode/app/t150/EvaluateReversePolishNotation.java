package ru.leetcode.app.t150;

import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class EvaluateReversePolishNotation {
    /**
     * https://leetcode.com/problems/evaluate-reverse-polish-notation/
     * <p>
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     * <p>
     * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
     * <p>
     * Note that division between two integers should truncate toward zero.
     * <p>
     * It is guaranteed that the given RPN expression is always valid. That means the expression would always
     * evaluate to a result, and there will not be any division by zero operation.
     * <p>
     * Example 1:
     * <p>
     * Input: tokens = ["2","1","+","3","*"]
     * Output: 9
     * Explanation: ((2 + 1) * 3) = 9
     * Example 2:
     * <p>
     * Input: tokens = ["4","13","5","/","+"]
     * Output: 6
     * Explanation: (4 + (13 / 5)) = 6
     * Example 3:
     * <p>
     * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
     * Output: 22
     * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
     * = ((10 * (6 / (12 * -11))) + 17) + 5
     * = ((10 * (6 / -132)) + 17) + 5
     * = ((10 * 0) + 17) + 5
     * = (0 + 17) + 5
     * = 17 + 5
     * = 22
     */
    public static void main(String[] args) {
        assertEquals(9, new Solution().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        assertEquals(6, new Solution().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        assertEquals(22, new Solution().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+",
                "5", "+"}));
    }

    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<String> numbers = new Stack<>();
            List<String> operations = List.of("+", "-", "/", "*");
            int index = 0;
            while (index < tokens.length) {
                if (operations.contains(tokens[index])) {
                    String second = numbers.pop();
                    String first = numbers.pop();
                    int result = performOperation(first, second, tokens[index++]);
                    numbers.push(Integer.toString(result));
                } else {
                    numbers.push(tokens[index++]);
                }
            }
            return Integer.parseInt(numbers.pop());
        }

        private int performOperation(String first, String second, String operation) {
            int result;
            switch (operation) {
                case "+":
                    result = Integer.parseInt(first) + Integer.parseInt(second);
                    break;
                case "-":
                    result = Integer.parseInt(first) - Integer.parseInt(second);
                    break;
                case "/":
                    result = Integer.parseInt(first) / Integer.parseInt(second);
                    break;
                case "*":
                    result = Integer.parseInt(first) * Integer.parseInt(second);
                    break;
                default:
                    result = 0;
            }
            return result;
        }
    }
}
