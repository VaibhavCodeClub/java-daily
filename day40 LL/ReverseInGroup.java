// Leetcode 25. Reverse Nodes in k-Group
/*
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.
*/

class Node {

  int data;
  Node next;

  public Node(int data) {
    this.data = data;
  }
}

public class ReverseInGroup {

  static void printLL(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " -> ");
      temp = temp.next;
    }
    System.out.println("null");
  }

  static Node convertArr2LL(int[] arr) {
    Node head = new Node(arr[0]);
    Node mover = head;
    for (int i = 1; i < arr.length; i++) {
      Node temp = new Node(arr[i]);
      mover.next = temp;
      mover = mover.next;
    }
    return head;
  }

  public static void main(String[] args) {
    Node head = convertArr2LL(new int[] { 1, 2, 3, 4, 5 });
    printLL(head);
    // head = reverseKGroup(head, 3);
    // printLL(head);

    head = rotateRight(head, 2);
    printLL(head);
  }

  private static Node getKthNode(Node temp, int k) {
    k -= 1;
    while (temp != null && k > 0) {
      k--;
      temp = temp.next;
    }
    return temp;
  }

  private static Node reverseLinkedList(Node temp) {
    Node prev = null, curr = temp;
    while (curr != null) {
      Node next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev; // Returns new head of reversed segment
  }

  public static Node reverseKGroup(Node head, int k) {
    Node temp = head, prevNode = null, nextNode = null;
    while (temp != null) {
      Node kthNode = getKthNode(temp, k);
      // Check if we have enough nodes to reverse
      if (kthNode == null) {
        if (prevNode != null) {
          prevNode.next = temp; // Connect remaining nodes
        }
        break; // Exit if not enough nodes left
      }
      nextNode = kthNode.next; // Store next group's starting point
      kthNode.next = null; // Temporarily terminate the current group for reversal
      // Reverse current group
      Node reversedHead = reverseLinkedList(temp);
      if (prevNode == null) {
        head = reversedHead; // Update head for the first group
      } else {
        prevNode.next = reversedHead; // Connect previous group's end to current reversed head
      }
      temp.next = nextNode; // Connect last node of reversed group to next group start
      prevNode = temp; // Move prevNode to current group's start
      temp = nextNode; // Move to next group
    }
    return head;
  }

  public static Node rotateRight(Node head, int k) {
    if (head == null || head.next == null) return head;
    Node temp = head;
    int length = 1;
    while (temp.next != null) {
      length++;
      temp = temp.next;
    }
    k = k % length;
    if (k == 0) return head;
    temp.next = head;

    int stepsToNewHead = length - k;

    temp = head;
    for (int i = 1; i < stepsToNewHead; i++) {
      temp = temp.next;
    }
    head = temp.next;
    temp.next = null;
    return head;
  }
}
