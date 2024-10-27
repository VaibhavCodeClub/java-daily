// Add Two Numbers
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class leet2 {
  public static void main(String[] args) {
    int[] arr1 = { 2, 4, 3 };
    int[] arr2 = { 5, 6, 4 };

    ListNode l1 = createList(arr1);
    ListNode l2 = createList(arr2);

    leet2 solution = new leet2();
    ListNode result = solution.addTwoNumbers(l1, l2);

    printList(result);
  }

  private static ListNode createList(int[] arr) {
    ListNode dummyHead = new ListNode(0);
    ListNode current = dummyHead;
    for (int num : arr) {
      current.next = new ListNode(num);
      current = current.next;
    }
    return dummyHead.next;
  }

  private static void printList(ListNode head) {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    System.out.println();
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode result = new ListNode(0);
    ListNode ptr = result;

    int carry = 0;

    while (l1 != null || l2 != null) {
      int sum = 0 + carry;

      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }

      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }

      carry = sum / 10;
      sum = sum % 10;
      ptr.next = new ListNode(sum);
      ptr = ptr.next;
    }

    if (carry == 1)
      ptr.next = new ListNode(1);

    return result.next;
  }
}
