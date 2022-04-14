package ru.leetcode.app.t784;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

public class LetterCasePermutation {

    /**
     * https://leetcode.com/problems/letter-case-permutation/
     *
     * <p>
     * Given a string s, you can transform every letter individually to be lowercase
     * or uppercase to create another string.
     * Return a list of all possible strings we could create. Return the output in any order.
     */
    public static void main(String[] args) {
        List<String> a1b2 = letterCasePermutation("a1b2");
        Assert.assertEquals(List.of("a1b2", "a1B2", "A1b2", "A1B2"), a1b2);

        a1b2 = letterCasePermutation("3z4");
        Assert.assertEquals(List.of("3z4", "3Z4"), a1b2);
    }


    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        calc(result, s, "", 0);
        return result;
    }

    private static void calc(List<String> result, String s, String curr, int i) {
        if (i == s.length()) {
            result.add(curr);
            return;
        }

        char c = s.charAt(i);

        if (Character.isLetter(c)) {
            // Letter has two options ->  lowercase or uppercase
            calc(result, s, curr + Character.toLowerCase(c), i + 1);
            calc(result, s, curr + Character.toUpperCase(c), i + 1);
        } else {
            // Number has only one option -> itself
            calc(result, s, curr + c, i + 1);
        }
    }
}
