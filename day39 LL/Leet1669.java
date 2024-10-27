// Merge In Between Linked Lists
/*
You are given two linked lists: list1 and list2 of sizes n and m respectively.
Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
Input: list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
Output: [10,1,13,1000000,1000001,1000002,5]
Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.
*/
import java.util.*;

class ListNode {

  int data;
  ListNode next;

  public ListNode(int data) {
    this.data = data;
  }
}

public class Leet1669 {

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
    // ListNode head = convertArr2LL(new int[] { 1, 2, 3, 4, 5 });
    // printLL(head);
    ListNode headA = convertArr2LL(new int[] { 10, 1, 13, 6, 9, 5 });
    ListNode headB = convertArr2LL(new int[] { 1000000, 1000001, 1000002 });
    printLL(headA);
    printLL(mergeInBetween(headA, 3, 4, headB));
  }

  static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    int cnt = 0;
    ListNode temp = list1;

    while (cnt < a - 1) {
      temp = temp.next;
      cnt++;
    }

    ListNode prevA = temp;

    while (cnt < b) {
      temp = temp.next;
      cnt++;
    }

    ListNode afterB = temp.next;

    prevA.next = list2;

    while (list2.next != null) {
      list2 = list2.next;
    }

    list2.next = afterB;

    return list1;
  }
}
