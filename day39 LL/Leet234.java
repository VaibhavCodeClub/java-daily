// Palindrome Linked List
// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

public class Leet234 {

  static void printLL(ListNode head) {
    ListNode temp = head;
    while (temp != null) {
      System.out.print(temp.val + " -> ");
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
    ListNode node = convertArr2LL(new int[] { 1, 6, 6, 6, 1 });
    printLL(node);
    System.out.println(isPalindrome(node));
  }

  public static boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;
    ListNode slow = head, fast = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    ListNode prev = null, curr = slow;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    // printLL(head);
    ListNode first = head, second = prev;
    while (second != null) {
      if (first.val != second.val) return false;
      second = second.next;
      first = first.next;
    }
    return true;
  }
}

class ListNode {

  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
