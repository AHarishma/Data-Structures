package com.company.stack;

public class ValidateParenthesis1 {
    public boolean validateParenthesis(String input) {
        int open = 0;
        int close = 0;
        for(char character : input.toCharArray()) {
            if(character == '(') {
                open++;
            } else if(character == ')') {
                close++;
            }
            if(open < close) {
                return false;
            }
        }
        return open == close;
    }
}

/**
 * TC: O(N)
 * SC: O(1)
 */
