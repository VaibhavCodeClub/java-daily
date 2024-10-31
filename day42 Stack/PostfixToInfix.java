import java.util.*;

public class PostfixToInfix {

  static String postToIn(String s) {
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if (Character.isLetterOrDigit(ch)) {
        stack.push(String.valueOf(ch));
      } else {
        String first = stack.pop();
        String second = stack.pop();
        String op = '(' + second + ch + first + ')';
        stack.push(op);
      }
    }
    // System.out.println(stack);
    return stack.peek();
  }

  // private static boolean operand(char ch) {
  //   return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
  // }

  public static void main(String[] args) {
    System.out.println(postToIn("ab*c+"));
  }
}
