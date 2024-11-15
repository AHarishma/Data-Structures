package com.company.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringLength {
    public int longestSubstringLengthWithKDistinctCharacters(String s, int k) {
        Map<Character, Integer> charCount = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLength = Integer.MIN_VALUE;
        while (j < s.length()) {
            charCount.put(s.charAt(j), charCount.getOrDefault(s.charAt(j), 0) + 1);
            if (charCount.size() == k) {
                maxLength = Math.max(maxLength, j - i + 1);
            } else if (charCount.size() > k) {
                while (charCount.size() > k) {
                    char leftChar = s.charAt(i);
                    charCount.put(leftChar, charCount.getOrDefault(leftChar, 0) - 1);
                    if (charCount.get(leftChar) == 0) {
                        charCount.remove(leftChar);
                    }
                    i++;
                }
            }
            j++;
        }
        return maxLength;
    }
}

/**
 * Variable size sliding window algorithm
 * <p>
 * Given a string you need to print longest possible substring that has exactly M unique characters. If there is more than one substring of longest possible length, then print any one of them.
 * <p>
 * Examples:
 * <p>
 * Input: Str = “aabbcc”, k = 1
 * Output: 2
 * Explanation: Max substring can be any one from {“aa” , “bb” , “cc”}.
 * <p>
 * Input: Str = “aabbcc”, k = 2
 * Output: 4
 * Explanation: Max substring can be any one from {“aabb” , “bbcc”}.
 */
