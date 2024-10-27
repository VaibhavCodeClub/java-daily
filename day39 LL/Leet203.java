// Given the head of a linked list and an integer val, remove all the nodes of the linked list that has ListNode.val == val, and return the new head.
//

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

public class Leet203 {

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

  static ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode temp = dummy;
    while (temp.next != null) {
      if (temp.next.val == val) {
        temp.next = temp.next.next;
      } else {
        temp = temp.next;
      }
    }
    return dummy.next;
  }

  static void display(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode temp = dummy;
    while (temp != null) {
      System.out.print(temp.val + " -> ");
      temp = temp.next;
    }
    System.out.println("NULL");
  }

  public static void main(String[] args) {
    ListNode node = convertArr2LL(new int[] { 1, 2, 6, 3, 4, 5, 6 });
    display(node);
    node = removeElements(node, 6);
    display(node);
  }
}
