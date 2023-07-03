package ru.leetcode.app.yandex;

import java.util.*;

public class Racktables {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            String query = scanner.nextLine();
            if (isValidQuery(query)) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        }
    }

    private static boolean isValidQuery(String query) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        StringBuilder buffer = new StringBuilder();
        boolean isNeedBracket = false;
        for (int i = 0; i < query.length(); i++) {
            char c = query.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                index.push(i);
                isNeedBracket = false;
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || !isValidClosingBracket(stack.pop(), c) || index.isEmpty() || i - index.pop() == 1) {
                    return false;
                }
                buffer = new StringBuilder();
            } else if (c != ' ') {
                buffer.append(c);
            } else if (buffer.toString().equals("or") || buffer.toString().equals("contains") || buffer.toString().equals("in")|| buffer.toString().equals("not")){
                buffer = new StringBuilder();
                isNeedBracket = true;
            }
        }
        if (isNeedBracket) return false;

        return stack.isEmpty();
    }

    private static boolean isValidClosingBracket(char opening, char closing) {
        return (opening == '(' && closing == ')') || (opening == '[' && closing == ']' || (opening == '{' && closing == '}'));
    }
}
