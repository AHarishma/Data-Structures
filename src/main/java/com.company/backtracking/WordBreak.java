package com.company.backtracking;

import java.util.*;

public class WordBreak {
    private Trie trie;
    private boolean wordBreak(String str, List<String> dict) {
        trie = new Trie();
        for(String word : dict) {
            trie.insertTrie(word);
        }
        return solveWordBreak(str, 0);
    }

    private boolean solveWordBreak(String str, int index) {
        if(index >= str.length()) {
            return true;
        }
        for(int i = index ; i < str.length(); i++) {
            if(trie.searchTrie(str.substring(index, i+1))) {
                return solveWordBreak(str, i + 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>(Arrays.asList("apple","pen"));
        String word = "applepenapple";
        System.out.println(new WordBreak().wordBreak(word, dict));
    }



    static class TrieNode {
        private final TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }

    static class Trie {
        private final TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insertTrie(String word) {
            TrieNode current = root;
            for(char ch : word.toCharArray()) {
                int index = ch - 'a';
                if(current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isEnd = true;
        }

        public boolean searchTrie(String word) {
            TrieNode current = root;
            for(char ch: word.toCharArray()) {
                int index = ch - 'a';
                if(current.children[index] == null) {
                    return false;
                }
                current = current.children[index];
            }
            return current.isEnd;
        }

    }
}

/**
 * Link: https://leetcode.com/problems/word-break/
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */



