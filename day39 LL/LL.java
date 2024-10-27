class Node {

  public int data;
  public Node next;

  public Node() {}

  public Node(int data, Node next) {
    this.data = data;
    this.next = next;
  }

  public Node(int data) {
    this.data = data;
    this.next = null;
  }
}

public class LL {

  static int lengthOfLL(Node head) {
    Node temp = head;
    int len = 0;
    while (temp != null) {
      len++;
      temp = temp.next;
    }
    return len;
  }

  static boolean isPresent(Node head, int key) {
    Node temp = head;
    while (temp != null) {
      if (temp.data == key) return true;
      temp = temp.next;
    }
    return false;
  }

  static void printLL(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " -> ");
      temp = temp.next;
    }
    System.out.println("null");
  }

  static Node deleteFirst(Node head) {
    if (head == null || head.next == null) return null;
    head = head.next;
    return head;
  }

  static Node deleteLast(Node head) {
    if (head == null || head.next == null) return null;
    Node temp = head;
    while (temp.next.next != null) temp = temp.next;
    temp.next = null;
    return head;
  }

  static Node deleteIndex(Node head, int index) {
    if (head == null) return null;
    if (index < 1) return head;
    if (index == 1) {
      return head.next;
    }
    // Node temp = head;
    // int i = 1;
    // while (temp != null && i < index - 1) {
    //   temp = temp.next;
    //   i++;
    // }
    // if (temp == null || temp.next == null) return head;
    // temp.next = temp.next.next;
    // return head;
    //
    Node temp = head;
    Node prev = null;
    int cnt = 0;
    while (temp != null) {
      cnt++;
      if (cnt == index) {
        prev.next = prev.next.next;
        break;
      }
      prev = temp;
      temp = temp.next;
    }
    return head;
  }

  static Node deleteValue(Node head, int val) {
    if (head == null) return null;
    if (head.data == val) return head.next;

    Node temp = head;
    Node prev = null;

    while (temp != null) {
      if (temp.data == val) {
        prev.next = prev.next.next;
        break;
      }
      prev = temp;
      temp = temp.next;
    }
    return head;
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

  static Node insertFirst(Node head, int val) {
    // if (head == null) return new Node(val);
    return new Node(val, head);
  }

  static Node insertLast(Node head, int val) {
    if (head == null) return new Node(val);
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = new Node(val);
    return head;
  }

  static Node insertIndex(Node head, int val, int index) {
    if (index == 1) return insertFirst(head, val);
    int cnt = 1;
    Node temp = head;
    while (temp != null && cnt < index - 1) {
      temp = temp.next;
      cnt++;
    }
    if (temp == null) return head;

    Node node = new Node(val, temp.next);
    temp.next = node;
    return head;
  }

  static Node insertBeforeValue(Node head, int val, int value) {
    if (head == null) return null;
    if (head.data == value) return insertFirst(head, val);

    Node temp = head;
    while (temp.next != null) {
      if (temp.next.data == value) {
        Node node = new Node(val, temp.next);
        temp.next = node;
        break;
      }
      temp = temp.next;
    }
    return head;
  }

  public static void main(String args[]) {
    Node node = new Node(2, null);
    // System.out.println(node.data);

    Node n = convertArr2LL(new int[] { 3, 55, 4, 3, 22 });
    printLL(n);
    // System.out.println(lengthOfLL(n));
    // System.out.println(isPresent(n, 4));

    n = deleteFirst(n);
    printLL(n);

    n = deleteLast(n);
    printLL(n);

    // n = deleteIndex(n, 3);
    // printLL(n);
    // n = deleteValue(n, 55);
    // printLL(n);
    n = insertLast(n, 33);
    printLL(n);
    n = insertIndex(n, 123, 5);
    printLL(n);
    n = insertBeforeValue(n, 99, 123);
    printLL(n);
    // node = deleteLast(node);
    // node = insertIndex(node, 99, 0);
    // printLL(node);
  }
}
