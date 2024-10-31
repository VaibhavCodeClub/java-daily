import java.util.*;

public class InfixToPrefix {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();

    sc.close();
    Stack<Character> stack = new Stack<>();
    StringBuffer reverse = new StringBuffer(str);
    reverse.reverse();
    StringBuffer ans = new StringBuffer();

    for (int i = 0; i < reverse.length(); i++) {
      if (reverse.charAt(i) == '(') reverse.setCharAt(i, ')');
      else if (reverse.charAt(i) == ')') reverse.setCharAt(i, '(');
    }

    for (int i = 0; i < reverse.length(); i++) {
      char ch = reverse.charAt(i);
      if (Character.isLetterOrDigit(ch)) ans.append(ch);
      else if (ch == '(') stack.push(ch);
      else if (ch == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          ans.append(stack.pop());
        }
        if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
      } else {
        while (!stack.isEmpty() && priority(ch) < priority(stack.peek())) {
          ans.append(stack.pop());
        }
        stack.push(ch);
      }
    }
    while (!stack.isEmpty()) {
      ans.append(stack.pop());
    }
    System.out.println(ans.reverse().toString());
  }

  private static int priority(char ch) {
    if (ch == '^') return 3;
    else if (ch == '+' || ch == '-') return 1;
    else if (ch == '/' || ch == '*') return 2;
    return 0;
  }
}
