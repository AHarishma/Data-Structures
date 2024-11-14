package com.company.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int longestSubstringLength = 0;
        int l = 0;
        int maxFrequency = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(int r = 0; r < s.length(); r++) {
            frequencyMap.put(s.charAt(r), frequencyMap.getOrDefault(s.charAt(r), 0) + 1);
            maxFrequency =  Math.max(frequencyMap.get(s.charAt(r)), maxFrequency);
            while((r - l + 1) - maxFrequency > k) {
                frequencyMap.put(s.charAt(l), frequencyMap.get(s.charAt(l)) - 1);
                l++;
            }
            longestSubstringLength = Math.max(r - l + 1, longestSubstringLength);
        }
        return longestSubstringLength;
    }
}

/**
 *
 * https://neetcode.io/problems/longest-repeating-substring-with-replacement
 *
 * You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k characters of the string and replace them with any other uppercase English character.
 *
 * After performing at most k replacements, return the length of the longest substring which contains only one distinct character.
 *
 * Example 1:
 *
 * Input: s = "XYYX", k = 2
 *
 * Output: 4
 * Explanation: Either replace the 'X's with 'Y's, or replace the 'Y's with 'X's.
 *
 * Example 2:
 *
 * Input: s = "AAABABB", k = 1
 *
 * Output: 5
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * 0 <= k <= s.length
 */