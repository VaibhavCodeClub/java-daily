import java.util.*;

public class MinStack {

  Stack<int[]> stack = new Stack<>();

  public MinStack() {}

  public void push(int val) {
    int small = val;
    if (!stack.isEmpty()) small = Math.min(val, stack.peek()[1]);
    stack.push(new int[] { val, small });
  }

  public void pop() {
    stack.pop();
  }

  public int top() {
    return stack.peek()[0];
  }

  public int getMin() {
    if (stack.isEmpty()) return -1;
    return stack.peek()[1];
  }

  public static void main(String[] args) {}
}
