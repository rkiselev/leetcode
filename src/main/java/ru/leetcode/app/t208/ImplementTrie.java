package ru.leetcode.app.t208;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ImplementTrie {
    /**
     * https://leetcode.com/problems/implement-trie-prefix-tree/
     *
     * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve
     * keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and
     * spellchecker.
     *
     * Implement the Trie class:
     *
     * Trie() Initializes the trie object.
     * void insert(String word) Inserts the string word into the trie.
     * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and
     * false otherwise.
     * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix
     * prefix, and false otherwise.
     */

    public static void main(String[] args) {
        var t = new Trie();
        t.insert("apple");
        assertTrue(t.search("apple"));
        assertFalse(t.search("app"));
        assertTrue(t.startsWith("app"));
        t.insert("app");
        assertTrue(t.search("app"));
    }

    static class Trie {
        private TrieNode node;

        public Trie() {
            node = new TrieNode();
        }

        public void insert(String word) {
            var search = node;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (search.children[c - 'a'] == null) {
                    search.children[c - 'a'] = new TrieNode(c, false);
                }
                search = search.children[c - 'a'];
            }
            search.end = true;
        }

        public boolean search(String word) {
            boolean result = true;
            int i = 0;
            var search = node;
            while (result && i < word.length()) {
                char c = word.charAt(i);
                if (c == '.') {

                } else {
                    if (search.children[c - 'a'] != null) {
                        search = search.children[c - 'a'];
                    } else {
                        result = false;
                    }
                }
                i++;
            }
            if (result) result = search.end;
            return result;

        }

        public boolean startsWith(String prefix) {
            boolean result = true;
            int i = 0;
            var search = node;
            while (result && i < prefix.length()) {
                char c = prefix.charAt(i);
                if (search.children[c - 'a'] != null) {
                    search = search.children[c - 'a'];
                } else {
                    result = false;
                }
                i++;
            }
            return result;
        }

        class TrieNode {
            TrieNode[] children;
            boolean end;
            char value;
            public TrieNode(char value, boolean end) {
                children = new TrieNode[26];
                this.end = end;
                this.value = value;
            }

            public TrieNode() {
                children = new TrieNode[26];
            }
        }
    }
}
