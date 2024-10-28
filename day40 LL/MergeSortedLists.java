/*
leetcode 23. Merge k Sorted Lists
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.*/

import java.util.*;

class Node {

  int data;
  Node next;

  public Node(int data) {
    this.data = data;
  }
}

public class MergeSortedLists {

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
    Node head = convertArr2LL(new int[] { 1, 4, 5 });
    Node head1 = convertArr2LL(new int[] { 1, 3, 4 });
    Node head2 = convertArr2LL(new int[] { 2, 6 });
    // Node head = convertArr2LL(new int[] { 1, 2, 3, 4, 5 });
    Node[] arr = new Node[] { head, head1, head2 };
    printLL(head);
    printLL(mergeKLists(arr));
  }

  public static Node mergeKLists(Node[] lists) {
    PriorityQueue<Node> minHeap = new PriorityQueue<>(
      (a, b) -> a.data - b.data
    );
    for (Node n : lists) {
      if (n != null) minHeap.add(n);
    }
    Node dummy = new Node(0);
    Node temp = dummy;

    while (!minHeap.isEmpty()) {
      Node minNode = minHeap.poll();
      temp.next = minNode;
      temp = temp.next;

      if (minNode.next != null) {
        minHeap.add(minNode.next);
      }
    }
    return dummy.next;
  }
}
