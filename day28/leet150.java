// Evaluate Reverse Polish Notation

/*
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

    The valid operators are '+', '-', '*', and '/'.
    Each operand may be an integer or another expression.
    The division between two integers always truncates toward zero.
    There will not be any division by zero.
    The input represents a valid arithmetic expression in a reverse polish notation.
    The answer and all the intermediate calculations can be represented in a 32-bit integer.

*/

import java.util.Stack;

public class leet150 {
  public static void main(String[] args) {
    System.out.println(evalRPN(new String[] { "2", "1", "+", "3", "*" }));
    System.out.println(evalRPN0(new String[] { "2", "1", "+", "3", "*" }));
  }

  private static boolean isSign(String s) {
    return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
  }

  public static int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String string : tokens) {
      if (isSign(string)) {
        int first = stack.pop();
        int second = stack.pop();

        if (string.equals("+")) {
          stack.push(second + first);
        } else if (string.equals("-")) {
          stack.push(second - first);
        } else if (string.equals("*")) {
          stack.push(second * first);
        } else {
          stack.push(second / first);
        }

      } else {
        stack.push(Integer.valueOf(string));
      }
    }
    return stack.pop();
  }

  // Below is better approach
  public static int evalRPN0(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String token : tokens) {
      if (isSign(token)) {
        int first = stack.pop();
        int second = stack.pop();
        switch (token) {
          case "+":
            stack.push(second + first);
            break;
          case "-":
            stack.push(second - first);
            break;
          case "*":
            stack.push(second * first);
            break;
          case "/":
            stack.push(second / first);
            break;
        }
      } else {
        stack.push(Integer.valueOf(token));
      }
    }
    return stack.pop();
  }
}
