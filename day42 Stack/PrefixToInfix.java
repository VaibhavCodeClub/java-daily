import java.util.*;

public class PrefixToInfix {

  static String preToIn(String s) {
    Stack<String> stack = new Stack<>();
    for (int i = s.length() - 1; i >= 0; i--) {
      char ch = s.charAt(i);
      if (Character.isLetterOrDigit(ch)) {
        stack.push(String.valueOf(ch));
      } else {
        String first = stack.pop();
        String second = stack.pop();
        String op = '(' + first + ch + second + ')';
        stack.push(op);
      }
    }
    return stack.pop();
  }

  public static void main(String[] args) {
    System.out.println(preToIn("*-a/bc-/dkl"));
  }
}
