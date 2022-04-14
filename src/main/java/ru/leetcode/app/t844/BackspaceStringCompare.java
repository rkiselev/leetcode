package ru.leetcode.app.t844;

import org.junit.Assert;

public class BackspaceStringCompare {

    /**
     * https://leetcode.com/problems/backspace-string-compare/
     *
     * Given two strings s and t, return true if they are equal when both are typed into empty text editors.
     * '#' means a backspace character.
     *
     * Note that after backspacing an empty text, the text will continue empty.
     */

    public static void main(String[] args) {
        Assert.assertTrue(backspaceCompare("ab#c", "ad#c"));
        Assert.assertTrue(backspaceCompare("ab##", "c#d#"));
        Assert.assertFalse(backspaceCompare("a#c", "b"));
    }

    public static boolean backspaceCompare(String s, String t) {
        s = formatString(s);
        t = formatString(t);
        return s.equals(t);
    }

    private static String formatString(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length();
        int countToSkeep = 0;
        while(i > 0) {
            char c = s.charAt(i-1);
            if (c == '#') {
                countToSkeep++;
            } else {
                if (countToSkeep == 0) {
                    result.append(c);
                } else {
                    countToSkeep--;
                }
            }
            i--;
        }
        return result.toString();
    }
}
