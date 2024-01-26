package com.company.stack;

import java.util.Stack;

public class RemovePairs {
    public String removePairs(String input) {
        Stack<Character> stack = new Stack<>();
        String result = "";
        for (char ch : input.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            result = ch + result;
        }

        return result;
    }
}
/**
 * Remove consecutive duplicate pairs in the string
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
 * <p>
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 * <p>
 * We repeatedly make duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * Example 2:
 * <p>
 * Input: s = "azxxzy"
 * Output: "ay"
 */