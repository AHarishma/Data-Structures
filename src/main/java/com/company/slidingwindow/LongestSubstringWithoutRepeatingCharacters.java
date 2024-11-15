package com.company.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) {
            return s.length();
        }
        Set<Character> characterSet = new HashSet<>();
        int l = 0;
        int r = 0;
        int longestSubstringLength = Integer.MIN_VALUE;

        while(r < s.length()) {
            while(characterSet.contains(s.charAt(r))) {
                characterSet.remove(s.charAt(l));
                l++;
            }
            characterSet.add(s.charAt(r));
            longestSubstringLength = Math.max(r - l + 1, longestSubstringLength);
            r++;
        }
        return longestSubstringLength;
    }
}

/**
 * https://neetcode.io/problems/longest-substring-without-duplicates
 *
 * Longest Substring Without Duplicates
 * Solved
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 *
 * Input: s = "zxyzxyz"
 *
 * Output: 3
 * Explanation: The string "xyz" is the longest without duplicate characters.
 *
 * Example 2:
 *
 * Input: s = "xxxx"
 *
 * Output: 1
 * Constraints:
 *
 * 0 <= s.length <= 1000
 * s may consist of printable ASCII characters.
 */
