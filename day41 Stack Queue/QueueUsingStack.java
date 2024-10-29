import java.util.*;

public class QueueUsingStack {

  Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();

  static void push(int val) {
    while (!s1.isEmpty()) {
      s2.add(s1.pop());
    }
    s1.push(val);
    while (!s2.isEmpty()) s1.push(s2.pop());
  }

  static int pop() {
    return s1.isEmpty() ? -1 : s1.pop();
  }

  static int top() {
    return s1.isEmpty() ? -1 : s1.peek();
  }

  public static void main(String[] args) {}
}
/*
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- > 0) {
            int query = sc.nextInt();
            if (query == 1) { // Insert
                int val = sc.nextInt();
                s1.push(val);
            } else if (query == 2) { // Remove
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                }
                if (!s2.isEmpty()) {
                    s2.pop();
                }
            } else if (query == 3) { // Retrieve Front
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                }
                System.out.println(s2.isEmpty() ? -1 : s2.peek());
            }
        }
        sc.close();
    }
}
*/
