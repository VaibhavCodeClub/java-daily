import java.util.*;

public class PostfixToPrefix {

  static String preToIn(String s) {
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (Character.isLetterOrDigit(ch)) {
        stack.push(String.valueOf(ch));
      } else {
        String first = stack.pop();
        String second = stack.pop();
        String op = ch + second + first;
        stack.push(op);
      }
    }
    return stack.pop();
  }

  public static void main(String[] args) {
    System.out.println(preToIn("ABC/-AK/L-*"));
  }
}
