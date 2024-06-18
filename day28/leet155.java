// Min Stack
/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

    MinStack() initializes the stack object.
    void push(int val) pushes the element val onto the stack.
    void pop() removes the element on the top of the stack.
    int top() gets the top element of the stack.
    int getMin() retrieves the minimum element in the stack.

You must implement a solution with O(1) time complexity for each function.
*/

import java.util.Stack;

public class leet155 {
  public static void main(String[] args) {
    // Instantiate the MinStack object
    MinStack minStack = new MinStack();

    // Push elements onto the stack
    minStack.push(3);
    minStack.push(5);
    minStack.push(2);
    minStack.push(1);

    // Call top and getMin methods
    System.out.println("Top element is: " + minStack.top()); // Should print the top element
    System.out.println("Minimum element is: " + minStack.getMin()); // Should print the minimum element

    // Pop an element
    minStack.pop();

    // Call top and getMin methods again
    System.out.println("Top element after pop is: " + minStack.top()); // Should print the new top element
    System.out.println("Minimum element after pop is: " + minStack.getMin()); // Should print the new minimum element
  }
}

class MinStack {
  private Stack<Integer> mainStack;
  private Stack<Integer> min;

  public MinStack() {
    mainStack = new Stack<>();
    min = new Stack<>();
  }

  public void push(int val) {
    if (mainStack.size() == 0 || min.peek() >= val)
      min.push(val);

    mainStack.push(val);
  }

  public void pop() {
    int a = mainStack.pop();
    if (min.peek() == a)
      min.pop();
  }

  public int top() {
    return mainStack.peek();
  }

  public int getMin() {
    return min.peek();
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */