import java.util.*;

public class InfixToPostfix {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    sc.close();
    StringBuilder ans = new StringBuilder();

    Stack<Character> stack = new Stack<>();
    for (char ch : str.toCharArray()) {
      if (
        (ch >= 'A' && ch <= 'Z') ||
        (ch >= 'a' && ch <= 'z') ||
        (ch >= '0' && ch <= '9')
      ) ans.append(ch);
      else if (ch == '(') stack.push(ch);
      else if (ch == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          ans.append(stack.pop());
        }
        if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
      } else {
        while (!stack.isEmpty() && priority(ch) <= priority(stack.peek())) {
          ans.append(stack.pop());
        }
        stack.push(ch);
      }
    }
    while (!stack.isEmpty()) {
      ans.append(stack.pop());
    }
    System.out.println(ans);
  }

  private static int priority(char ch) {
    if (ch == '^') return 3;
    if (ch == '*' || ch == '/') return 2;
    if (ch == '+' || ch == '-') return 1;
    return 0;
  }
}
