package ru.leetcode.app.t187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RepeatedDNASequences {
    /**
     * https://leetcode.com/problems/repeated-dna-sequences/
     *
     * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
     *
     * For example, "ACGAATTCCG" is a DNA sequence.
     * When studying DNA, it is useful to identify repeated sequences within the DNA.
     *
     * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that
     * occur more than once in a DNA molecule. You may return the answer in any order.
     *
     * Example 1:
     *
     * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     * Output: ["AAAAACCCCC","CCCCCAAAAA"]
     * Example 2:
     *
     * Input: s = "AAAAAAAAAAAAA"
     * Output: ["AAAAAAAAAA"]
     */

    public static void main(String[] args) {
        new Solution().findRepeatedDnaSequences("AAAAAAAAAAAAA");
    }

    static class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Set<String> result = new HashSet<>();
            Set<String> visited = new HashSet<>();
            for (int start = 0; start < s.length() - 9; start++) {
                String value = s.substring(start, start + 10);
                if (!visited.add(value)) {
                    result.add(value);
                }
            }
            return new ArrayList<>(result);
        }
    }
}
