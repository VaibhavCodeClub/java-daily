// Sort linked list of 0s 1s 2s
// Given a linked list where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to the head side, 2s at the end of the linked list, and 1s in the middle of 0s and 2s.
//
import java.util.*;

class Node {

  int data;
  Node next;

  public Node(int data) {
    this.data = data;
  }
}

public class Segerate {

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
    printLL(segregate(head));
    Node headA = convertArr2LL(new int[] { 4, 1, 8, 4, 5 });
    Node headB = convertArr2LL(new int[] { 5, 6, 1, 8, 4, 5 });

    printLL(getIntersectionNode(headA, headB));
    printLL(findIntersection(headA, headB));
  }

  static Node segregate(Node head) {
    int zeroes = 0, ones = 0, twos = 0;

    Node tmep = head;
    while (tmep != null) {
      if (tmep.data == 0) zeroes++;
      else if (tmep.data == 1) ones++;
      else twos++;
      tmep = tmep.next;
    }
    tmep = head;
    while (zeroes != 0) {
      tmep.data = 0;
      zeroes--;
      tmep = tmep.next;
    }
    while (ones != 0) {
      tmep.data = 1;
      ones--;
      tmep = tmep.next;
    }
    while (twos != 0) {
      tmep.data = 2;
      twos--;
      tmep = tmep.next;
    }
    return head;
  }

  public static Node getIntersectionNode(Node headA, Node headB) {
    HashMap<Node, Integer> map = new HashMap<>();

    Node temp = headA;
    while (temp != null) {
      map.put(temp, map.getOrDefault(temp, 0) + 1);
      temp = temp.next;
    }
    temp = headB;
    while (temp != null) {
      map.put(temp, map.getOrDefault(temp, 0) + 1);
      if (map.get(temp) == 2) return temp;
      temp = temp.next;
    }
    temp = headA;
    return null;
    /*

    ListNode A = headA;
    ListNode B = headB;

    while(A != B)
    {
        A = (A == null) ? headB : A.next;
        B = (B == null) ? headA : B.next;
    }

    return A;
    */
  }

  static Node findIntersection(Node headA, Node headB) {
    HashSet<Integer> set = new HashSet<>();
    Node dummy = new Node(0); // Dummy node to start the result list
    Node ans = dummy;

    // Add all values from headB to the set
    Node temp = headB;
    while (temp != null) {
      set.add(temp.data); // Using 'data' instead of 'val'
      temp = temp.next;
    }

    // Traverse headA and check if the value exists in headB (set)
    temp = headA;
    while (temp != null) {
      if (set.contains(temp.data)) {
        ans.next = new Node(temp.data); // Create a new node with the intersecting value
        ans = ans.next;
      }
      temp = temp.next;
    }

    return dummy.next; // Return the result list starting from the next node of dummy
  }
}
