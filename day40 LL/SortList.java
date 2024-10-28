class Node {

  int data;
  Node next;

  public Node(int data) {
    this.data = data;
  }
}

public class SortList {

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
    Node head = convertArr2LL(new int[] { 4, 2, 5, 78, 5, 1, 0, 10 });
    printLL(head);
    printLL(mergeSort(head));
  }

  static Node findMiddle(Node head) {
    Node slow = head, fast = head.next;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  static Node mergeSort(Node head) {
    if (head == null || head.next == null) return head;
    Node mid = findMiddle(head);

    Node leftNode = head, rightNode = mid.next;
    mid.next = null;

    leftNode = mergeSort(leftNode);
    rightNode = mergeSort(rightNode);
    return merge(leftNode, rightNode);
  }

  static Node merge(Node leftHead, Node rightHead) {
    Node dymmy = new Node(0);
    Node temp = dymmy;
    while (leftHead != null && rightHead != null) {
      if (leftHead.data < rightHead.data) {
        temp.next = leftHead;
        leftHead = leftHead.next;
        temp = temp.next;
      } else {
        temp.next = rightHead;
        rightHead = rightHead.next;
        temp = temp.next;
      }
    }
    if (leftHead != null) temp.next = leftHead;
    else temp.next = rightHead;
    return dymmy.next;
  }
}
