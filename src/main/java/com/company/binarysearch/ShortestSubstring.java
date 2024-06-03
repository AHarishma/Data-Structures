package com.company.binarysearch;

import java.util.HashMap;
import java.util.Map;

public class ShortestSubstring {
    public int shortestSubstring(String string) {
        int left = 3;
        int right = string.length();
        int answer = string.length();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (substringExists(string, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    private boolean substringExists(String string, int length) {
        Map<Character, Integer> map = new HashMap<>();
        int right = 0;
        for (; right < length; right++) {
            char ch = string.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        if (map.size() == 3) {
            return true;
        }
        int left = 0;
        for (; right < string.length(); right++) {
            char ch = string.charAt(left);
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) == 0) {
                map.remove(ch);
            }
            ch = string.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.size() == 3) {
                return true;
            }
            left++;
        }
        return false;
    }

    // Sliding Window Technique:
    /* public int shortestSubstring(String string) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int answer = string.length();
        while (right < string.length()) {
            char ch = string.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() == 3) {
                answer = Math.min(answer, right - left + 1);
                ch = string.charAt(left);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
                left++;
            }
            right++;
        }
        return answer;
    } */
    /**
     *  Time Complexity: O(n)
     * Space Complexity: O(1)
     */

}

/**
 * Given a string which contains only a, b and c. Find the length of shortest substring which has all the characters(a, b & c) in it.
 * <p>
 * String: aaaabbcbbbaccccab
 * Output: 3
 * <p>
 * String: aaaabbcbbb
 * Output: 4
 * <p>
 * String: acb
 * Output: 3
 * <p>
 * String: abbbbbbbbbbbbbbbbbbc
 * Output: 20
 * <p>
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 */
