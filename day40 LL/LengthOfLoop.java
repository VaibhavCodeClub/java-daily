import java.util.*;

class Node {

  int data;
  Node next;

  public Node(int data) {
    this.data = data;
  }
}

public class LengthOfLoop {

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
    System.out.println(lengthOfLoop(head));
  }

  static int lengthOfLoop(Node head) {
    HashMap<Node, Integer> map = new HashMap<>();
    Node temp = head;
    int timer = 1;
    while (temp != null) {
      if (!map.containsKey(temp)) map.put(temp, timer);
      else return timer - map.get(temp);
      timer++;
      temp = temp.next;
    }
    return 0;
  }
}
