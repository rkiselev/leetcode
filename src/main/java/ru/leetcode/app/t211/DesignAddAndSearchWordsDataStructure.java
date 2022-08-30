package ru.leetcode.app.t211;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        var w = new WordDictionary();
        w.addWord("a");
        w.addWord("ad");
        assertTrue(w.search("a"));
        assertFalse(w.search(".a"));
        assertTrue(w.search("a."));
    }

    static class WordDictionary {
        Trie root;
        public WordDictionary() {
            root = new Trie();
        }

        public void addWord(String word) {
            var current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new Trie(c);
                }
                current = current.children[c - 'a'];
            }
            current.end = true;
        }

        public boolean search(String word) {
            return search(word, null);
        }

        private boolean search(String word, Trie start) {
            var current = start == null ? root: start;
            var found = true;
            int i = 0;
            while(found && i < word.length()) {
                char c = word.charAt(i);
                if (c == '.') {
                    for (Trie trie : current.children) {
                        if (trie == null) continue;
                        String postword = i + 1 < word.length() ? word.substring(i + 1) : "";
                        if (search(postword, trie)) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    current = current.children[c - 'a'];
                    found = current != null;
                }
                i++;
            }
            if (found) found = current.end;
            return found;
        }

        class Trie {
            Trie[] children;
            char value;
            boolean end;
            public Trie() {
                children = new Trie[26];
            }
            public Trie(char value) {
                children = new Trie[26];
                this.value = value;
            }
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
