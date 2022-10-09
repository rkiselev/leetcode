package ru.leetcode.app.t17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Character, List<String>> map = Map.of(
            '2', List.of("a", "b", "c"),
            '3', List.of("d", "e", "f"),
            '4', List.of("g", "h", "i"),
            '5', List.of("j", "k", "l"),
            '6', List.of("m", "n", "o"),
            '7', List.of("p", "q", "r", "s"),
            '8', List.of("t", "u", "v"),
            '9', List.of("w", "x", "y", "z"),
            '0', List.of(),
            '1', List.of()

    );
    List<String> result;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits.length() == 0) return result;
        build(digits, 0, "");
        return result;
    }

    private void build(String digits, int index, String s) {
        if (index == digits.length()) {
            result.add(s);
            return;
        }

        var c = digits.charAt(index);
        for (String target : map.get(c)) {
            build(digits, index + 1, s + target);
        }
    }
}
