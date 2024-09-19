// Reverse Substrings Between Each Pair of Parentheses
/*
You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.
*/

import java.util.Stack;

public class leet1190 {
  public static void main(String[] args) {
    System.out.println(reverseParentheses("(u(love)i)"));
  }

  public static String reverseParentheses(String s) {
    Stack<StringBuilder> stack = new Stack<>();
    StringBuilder current = new StringBuilder();
    for (char character : s.toCharArray()) {
      if (character == '(') {
        stack.push(current);
        current = new StringBuilder();
      } else if (character == ')') {
        current.reverse();
        current = stack.pop().append(current);
      } else {
        current.append(character);
      }
    }
    return current.toString();
  }
}
