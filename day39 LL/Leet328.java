// Odd Even Linked List
/*
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.
*/
import java.util.ArrayList;

class ListNode {

  int data;
  ListNode next;

  public ListNode(int data) {
    this.data = data;
  }
}

public class Leet328 {

  static void printLL(ListNode head) {
    ListNode temp = head;
    while (temp != null) {
      System.out.print(temp.data + " -> ");
      temp = temp.next;
    }
    System.out.println("null");
  }

  static ListNode convertArr2LL(int[] arr) {
    ListNode head = new ListNode(arr[0]);
    ListNode mover = head;
    for (int i = 1; i < arr.length; i++) {
      ListNode temp = new ListNode(arr[i]);
      mover.next = temp;
      mover = mover.next;
    }
    return head;
  }

  public static void main(String[] args) {
    ListNode head = convertArr2LL(new int[] { 1, 2, 3, 4, 5 });
    printLL(head);
    printLL(oddEvenList(head));
  }

  public static ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == head) return head;
    ListNode temp = head;
    ArrayList<Integer> arr = new ArrayList<>();
    // Collect even values first
    while (temp != null) {
      if (temp.data % 2 == 0) arr.add(temp.data);
      temp = temp.next;
    }
    // Collect odd values
    temp = head;
    while (temp != null) {
      if (temp.data % 2 == 1) arr.add(temp.data);
      temp = temp.next;
    }
    // Reassign values from the list back to the linked list
    temp = head;
    int i = 0;
    while (temp != null) {
      temp.data = arr.get(i++);
      temp = temp.next;
    }
    return head;
  }

  public static ListNode oddEven(ListNode head) {
    if (head == null || head.next == head) return head;

    ListNode odd = head, even = head.next;
    ListNode evenPos = even;

    while (even != null && even.next != null) {
      odd.next = odd.next.next;
      even.next = even.next.next;
      odd = odd.next;
      even = even.next;
    }
    odd.next = evenPos;
    return head;
  }
}
