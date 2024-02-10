package com.company.stack;

import java.util.Stack;

public class ValidateParenthesis {
  public boolean validateParenthesis(String input) {
      Stack<Character> stack = new Stack<>();
      for(char character : input.toCharArray()) {
          if(character == '(') {
              stack.push(character);
          } else {
              if(!stack.isEmpty()) {
                  stack.pop();
              } else {
                  return false;
              }
          }
      }
      return stack.isEmpty();
  }
}
/**
 * TC: O(N)
 * SC: O(N)
 */
