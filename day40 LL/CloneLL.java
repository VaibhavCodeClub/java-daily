import java.util.*;

class Node {

  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}

public class CloneLL {

  static void printLL(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(
        // "Value: " +
        temp.val +
        " : " +
        // ", Random: " +
        (temp.random != null ? temp.random.val : "null") +
        " -> "
      );
      temp = temp.next;
    }
    System.out.println("null");
  }

  static Node convertArr2LL(int[] arr, int[] random) {
    Node head = new Node(arr[0]);
    Node mover = head;
    Node[] nodeArray = new Node[arr.length];
    nodeArray[0] = head; // Store the first node

    // Create nodes and store references
    for (int i = 1; i < arr.length; i++) {
      Node temp = new Node(arr[i]);
      mover.next = temp;
      mover = mover.next;
      nodeArray[i] = temp; // Store the current node
    }

    // Set the random pointers
    for (int i = 0; i < arr.length; i++) {
      if (random[i] != -1) { // -1 means no random pointer
        nodeArray[i].random = nodeArray[random[i] - 1]; // Set the random pointer (1-based index)
      }
    }

    return head;
  }

  public static void main(String[] args) {
    Node head = convertArr2LL(
      new int[] { 7, 13, 11, 10, 1 },
      new int[] { -1, 1, 3, 2, -1 }
    );
    printLL(head);
    printLL(copyRandomList(head));
  }

  static Node copyRandomList(Node head) {
    // Node dummy = new Node(0);
    // Node curr = dummy;
    HashMap<Node, Node> map = new HashMap<>();
    Node temp = head;
    while (temp != null) {
      Node node = new Node(temp.val);
      map.put(temp, node);
      temp = temp.next;
      //   Node node = new Node(temp.val);
      //   curr.next = node;
      //   curr = curr.next;
      //   temp = temp.next;
      // }
      // temp = head;
      // curr = dummy.next;
      // while (temp != null) {
      //   curr.random = temp.random;
      //   curr = curr.next;
      //   temp = temp.next;
    }

    temp = head;
    while (temp != null) {
      Node curr = map.get(temp);
      curr.next = map.get(temp.next);
      curr.random = map.get(temp.random);
      temp = temp.next;
    }

    return map.get(head);
  }
}
