package ru.leetcode.app.t151;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;

public class ReverseWordsString {
    /**
     * https://leetcode.com/problems/reverse-words-in-a-string/
     *
     * Given an input string s, reverse the order of the words.
     *
     * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
     *
     * Return a string of the words in reverse order concatenated by a single space.
     *
     * Note that s may contain leading or trailing spaces or multiple spaces between two words.
     * The returned string should only have a single space separating the words. Do not include any extra spaces.
     *
     */
    public static void main(String[] args) {
        Assert.assertEquals("blue is sky the", reverseWords("the sky is blue"));

        Assert.assertEquals("world hello", reverseWords("  hello world  "));

        Assert.assertEquals("example good a", reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        var arr = s.split(" ");
        List<String> sb = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            var toAdd = arr[i].replace(" ","");
            if (toAdd.length() > 0) sb.add(toAdd);
        }
        return String.join(" ", sb);
    }
}
