package ru.leetcode.app.t844;

import org.junit.Assert;

import java.util.concurrent.ExecutorService;

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
        Assert.assertFalse(backspaceCompare("bxj##tw", "bxj###tw"));
        Assert.assertTrue(backspaceCompare("ab##", "c#d#"));
        Assert.assertTrue(backspaceCompare("xywrrmp", "xywrrmu#p"));
        Assert.assertTrue(backspaceCompare("ab#c", "ad#c"));
        Assert.assertFalse(backspaceCompare("a#c", "b"));
    }

    public static boolean backspaceCompare(String s, String t) {
        boolean same = true;
        int i = s.length() - 1;
        int j = t.length() - 1;
        while(same && (i>= 0 || j >= 0)){
            char sChar = i >= 0 ? s.charAt(i) : 'A';
            char tChar = j >= 0 ? t.charAt(j) : 'A';
            int skip = 0;
            while((sChar == '#' || skip > 0) && i>=0) {
                skip += sChar == '#' ? 1: -1;
                i--;
                sChar = i >= 0 ? s.charAt(i) : 'A';
            }
            skip = 0;
            while((tChar == '#' || skip > 0) && j>=0) {
                skip += tChar == '#' ? 1: -1;
                j--;
                tChar = j >= 0 ? t.charAt(j) : 'A';
            }
            same = tChar == sChar;
            i--;
            j--;
        }
        return same && i < 0 && j < 0 ;
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
