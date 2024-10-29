import java.util.*;

public class StackUsingQueue {

  static Queue<Integer> queue = new LinkedList<>();

  static void push(int x) {
    int s = queue.size();
    queue.add(x);
    for (int i = 0; i < s; i++) {
      queue.add(queue.remove());
    }
  }

  static int pop() {
    if (queue.isEmpty()) return -1;
    return queue.remove();
  }

  static int top() {
    if (queue.isEmpty()) return -1;
    return queue.peek();
  }

  static boolean empty() {
    return queue.isEmpty();
  }

  public static void main(String[] args) {
    push(10);
    push(20);
    push(30);

    System.out.println("Top element: " + top()); // Output: 30
    System.out.println("Popped element: " + pop()); // Output: 30
    System.out.println("Top element after pop: " + top());
  }
}
