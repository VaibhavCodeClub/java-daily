import java.util.*;

class Stack {

  int top = -1;
  int stack[];
  int size;

  Stack(int size) {
    stack = new int[size];
    this.size = size;
  }

  void push(int val) {
    if (top + 1 == size) System.out.println("StackOverflow");
    else stack[++top] = val;
  }

  int pop() {
    if (top == -1) {
      System.out.println("StackUnderflow");
      return -1;
    } else return stack[top--];
  }

  int top() {
    if (top == -1) {
      System.out.println("StackUnderflow");
      return -1;
    } else return stack[top];
  }
}

class Queue {

  int size;
  int front = -1, rear = -1;
  int queue[];

  Queue(int size) {
    queue = new int[size];
    this.size = size;
  }

  void enqueue(int value) {
    if (rear + 1 == size) {
      System.out.println("queue full");
    } else {
      if (front == -1) {
        front = 0;
      }
      queue[++rear] = value;
    }
  }

  int dequeue() {
    if (front > rear && front == -1) {
      System.out.println("queue empty ");
      return -1;
    }
    return queue[front++];
  }

  int peek() {
    if (front == -1) {
      System.out.println("Queue is empty");
      return -1;
    } else return queue[front];
  }

  boolean isEmpty() {
    return front == -1;
  }
}

public class Stack1 {

  public static void main(String[] args) {
    // Stack st = new Stack(10);
    // st.push(1);
    // System.out.println(st.top());
    // System.out.println(st.pop());
    // st.pop();
    //
    Queue q = new Queue(5);
    q.enqueue(10);
    System.out.println(q.peek());
  }
}
