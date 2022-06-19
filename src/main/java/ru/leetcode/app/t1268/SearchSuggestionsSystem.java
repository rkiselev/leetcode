package ru.leetcode.app.t1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {
    /**
     * https://leetcode.com/problems/search-suggestions-system/
     *
     * You are given an array of strings products and a string searchWord.
     *
     * Design a system that suggests at most three product names from products after each character of searchWord is
     * typed. Suggested products should have common prefix with searchWord. If there are more than three products
     * with a common prefix return the three lexicographically minimums products.
     *
     * Return a list of lists of the suggested products after each character of searchWord is typed.
     *
     * Example 1:
     *
     * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
     * Output: [
     * ["mobile","moneypot","monitor"],
     * ["mobile","moneypot","monitor"],
     * ["mouse","mousepad"],
     * ["mouse","mousepad"],
     * ["mouse","mousepad"]
     * ]
     * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
     * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
     * After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
     *
     * Example 2:
     *
     * Input: products = ["havana"], searchWord = "havana"
     * Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
     *
     * Example 3:
     *
     * Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
     * Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
     *
     */
    public static void main(String[] args) {
        new Solution().suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse");
    }

    static class Solution {
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Arrays.sort(products);
            StringBuilder str = new StringBuilder();
            List<List<String>> result = new ArrayList<>();
            int start = 0;
            int end = products.length - 1;
            for (int i = 0; i < searchWord.length(); i++) {
                char c = searchWord.charAt(i);
                str.append(c);
                while(start <= end && !products[start].startsWith(str.toString())) {
                    start++;
                }
                while(start <= end && !products[end].startsWith(str.toString())) {
                    end--;
                }
                result.add(get3OrLess(start, end, products));
            }
            return result;
        }

        private List<String> get3OrLess(int start, int end, String[] arr) {
            List<String> result = new ArrayList<>();
            int index = 0;
            while(start + index <= end && index < 3) {
                result.add(arr[start + index]);
                index++;
            }
            return result;

        }
    }
}
