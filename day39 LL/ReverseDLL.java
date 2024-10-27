import java.util.Stack;

public class ReverseDLL {

  static Node arrayToDLL(int[] arr) {
    if (arr.length == 0) return null;
    Node n = new Node(arr[0]);
    Node prev = n;
    for (int i = 1; i < arr.length; i++) {
      Node temp = new Node(arr[i], prev, null);
      prev.next = temp;
      prev = temp;
    }
    return n;
  }

  static void printDLL(Node head) {
    if (head == null) {
      System.out.println("null");
      return;
    }
    Node temp = head;
    System.out.print("null <> ");

    while (temp != null) {
      System.out.print(temp.data + " <> ");
      temp = temp.next;
    }
    System.out.println("null");
  }

  static Node reverse(Node head) {
    // Reversing DLL using the stack
    // Space complexity O(n) for stack
    Stack<Integer> stack = new Stack<>();

    Node temp = head;
    while (temp != null) {
      stack.push(temp.data);
      temp = temp.next;
    }
    temp = head;
    while (temp != null) {
      temp.data = stack.pop();
      temp = temp.next;
    }
    return head;
  }

  static Node reverseDLL(Node head) {
    Node temp = head;
    Node last = null;

    while (temp != null) {
      last = temp.prev;
      temp.prev = temp.next;
      temp.next = last;

      temp = temp.prev;
    }
    return last.prev;
  }

  public static void main(String[] args) {
    Node node = arrayToDLL(new int[] { 1, 2, 3, 4, 5 });
    printDLL(node);

    node = reverse(node);
    printDLL(node);

    node = reverseDLL(node);
    printDLL(node);
  }
}

class Node {

  int data;
  Node prev;
  Node next;

  public Node(int data) {
    this.data = data;
    this.prev = null;
    this.next = null;
  }

  public Node(int data, Node prev, Node next) {
    this.data = data;
    this.prev = prev;
    this.next = next;
  }
}
