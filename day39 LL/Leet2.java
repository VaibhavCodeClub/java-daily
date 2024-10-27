/*
 Add Two Numbers
You are given two non-negative numbers 'num1' and 'num2' represented in the form of linked lists.
The digits in the linked lists are stored in reverse order, i.e. starting from least significant digit (LSD) to the most significant digit (MSD), and each of their nodes contains a single digit.
Calculate the sum of the two numbers and return the head of the sum list.
*/
import java.util.Stack;

class LinkedListNode {

  int data;
  LinkedListNode next;

  public LinkedListNode(int data) {
    this.data = data;
  }
}

public class Leet2 {

  static void printLL(LinkedListNode head) {
    LinkedListNode temp = head;
    while (temp != null) {
      System.out.print(temp.data + " -> ");
      temp = temp.next;
    }
    System.out.println("null");
  }

  static LinkedListNode convertArr2LL(int[] arr) {
    LinkedListNode head = new LinkedListNode(arr[0]);
    LinkedListNode mover = head;
    for (int i = 1; i < arr.length; i++) {
      LinkedListNode temp = new LinkedListNode(arr[i]);
      mover.next = temp;
      mover = mover.next;
    }
    return head;
  }

  public static void main(String[] args) {
    LinkedListNode head1 = convertArr2LL(new int[] { 1, 2, 3, 4, 5 });
    LinkedListNode head2 = convertArr2LL(new int[] { 4, 5 });

    LinkedListNode head3 = addTwo(head1, head2);

    printLL(head3);
  }

  static LinkedListNode addTwoNumbers(
    LinkedListNode head1,
    LinkedListNode head2
  ) {
    int carry = 0;
    LinkedListNode temp1 = head1;
    LinkedListNode temp2 = head2;
    LinkedListNode dummy = new LinkedListNode(0);

    LinkedListNode curr = dummy;

    while (temp1 != null || temp2 != null) {
      int sum =
        (temp1 == null ? 0 : temp1.data) +
        (temp2 == null ? 0 : temp2.data) +
        carry;
      carry = sum / 10;
      sum %= 10;

      LinkedListNode LinkedListNode = new LinkedListNode(sum);
      curr.next = LinkedListNode;
      curr = curr.next;

      temp1 = temp1 == null ? null : temp1.next;
      temp2 = temp2 == null ? null : temp2.next;
    }
    if (carry > 0) {
      LinkedListNode LinkedListNode = new LinkedListNode(carry);
      curr.next = LinkedListNode;
    }
    return dummy.next;
  }

  static LinkedListNode addTwo(LinkedListNode l1, LinkedListNode l2) {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    while (l1 != null) {
      stack1.push(l1.data);
      l1 = l1.next;
    }
    while (l2 != null) {
      stack2.push(l2.data);
      l2 = l2.next;
    }

    int carry = 0;
    LinkedListNode dummy = new LinkedListNode(0);
    LinkedListNode curr = dummy;

    while (!stack1.isEmpty() || !stack2.isEmpty()) {
      int sum = carry;
      if (!stack1.isEmpty()) {
        sum += stack1.pop();
      }
      if (!stack2.isEmpty()) {
        sum += stack2.pop();
      }

      carry = sum / 10;
      curr.next = new LinkedListNode(sum % 10);
      curr = curr.next;
    }

    if (carry > 0) {
      curr.next = new LinkedListNode(carry);
    }
    dummy = reverse(dummy.next);

    while (dummy.data == 0) dummy = dummy.next;
    return dummy;
  }

  static LinkedListNode reverse(LinkedListNode head) {
    LinkedListNode prev = null;
    while (head != null) {
      LinkedListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
}
