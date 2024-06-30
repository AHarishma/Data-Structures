package com.company.array;

public class MaxNoOfVowels {
    public int maxVowels(String s, int k) {
        int max = Integer.MIN_VALUE;
        int totalCount = 0;
        for (int r = 0; r < k; r++) {
            if (isVowel(s.charAt(r))) {
                totalCount++;
            }
            max = Math.max(max, totalCount);
        }

        for (int r = k; r < s.length(); r++) {
            if (isVowel(s.charAt(r))) {
                totalCount++;
            }
            if (isVowel(s.charAt(r - k))) {
                totalCount--;
            }
            max = Math.max(max, totalCount);
        }
        return max;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
/**
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * <p>
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * Example 2:
 * <p>
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * Example 3:
 * <p>
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 */
