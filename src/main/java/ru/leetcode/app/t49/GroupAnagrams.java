package ru.leetcode.app.t49;

import java.util.*;

public class GroupAnagrams {

    /**
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     *
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     *
     *
     *
     * Example 1:
     *
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * Example 2:
     *
     * Input: strs = [""]
     * Output: [[""]]
     * Example 3:
     *
     * Input: strs = ["a"]
     * Output: [["a"]]
     */

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String word: strs) {
                var array = word.toCharArray();
                Arrays.sort(array);
                var sorted = String.valueOf(array);
                List<String> words;
                if (map.containsKey(sorted)) {
                    words = map.get(sorted);
                } else {
                    words = new ArrayList<String>();
                }
                words.add(word);
                map.put(sorted, words);
            }

            return new ArrayList<>(map.values());
        }
    }
}
