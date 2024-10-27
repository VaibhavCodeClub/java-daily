public class DLL {

  static Node arrayToDLL(int[] arr) {
    if (arr.length == 0) return null;
    Node n = new Node(arr[0]);
    Node prev = n;
    for (int i = 1; i < arr.length; i++) {
      Node temp = new Node(arr[i], prev, null);
      prev.next = temp;
      prev = temp;
    }
    return n;
  }

  static void printDLL(Node head) {
    if (head == null) {
      System.out.println("null");
      return;
    }
    Node temp = head;
    System.out.print("null <> ");

    while (temp != null) {
      System.out.print(temp.data + " <> ");
      temp = temp.next;
    }
    System.out.println("null");
  }

  static Node deleteFirst(Node head) {
    if (head == null || head.next == null) return null;

    head = head.next;
    head.prev = null;
    return head;
  }

  static Node deleteLast(Node head) {
    if (head == null || head.next == null) return null;
    Node temp = head;
    while (temp.next.next != null) {
      temp = temp.next;
    }
    temp.next.prev = null;
    temp.next = null;
    return head;
  }

  static Node deleteIndex(Node head, int index) {
    if (head == null) return null;
    int cnt = 0;
    Node temp = head;
    while (temp != null) {
      cnt++;
      if (cnt == index) break;
      temp = temp.next;
    }
    if (temp == null) return head;

    Node prev = temp.prev;
    Node next = temp.next;

    if (prev == null) return deleteFirst(head);
    if (next == null) return deleteLast(head);

    prev.next = next;
    next.prev = prev;
    temp.next = null;
    temp.prev = null;

    return head;
  }

  static Node deleteVal(Node head, int val) {
    // If the DLL is empty return null
    if (head == null) return null;

    // If the head is equal to val return deleteFirst function which deletes head
    if (head.data == val) return deleteFirst(head);

    // temp Node for iteration through DLL
    Node temp = head;
    // Iterate till end of DLL
    while (temp != null) {
      // if current Node's data is equal to val break the loop
      if (temp.data == val) break;
      temp = temp.next;
    }
    // If temp is equal to null means in entire DLL the provided val does not exists
    if (temp == null) return head;

    // Take previous and next of the current node such a way we can delete current node
    Node prev = temp.prev;
    Node next = temp.next;

    // If next is null it means we have to delete tail
    if (next == null) return deleteLast(head);

    // set the connections to skip current node
    prev.next = next;
    next.prev = prev;

    // remove outgoing prev and next of current Node such a way garbage collecter can free its memory
    temp.prev = null;
    temp.next = null;
    return head;
  }

  static Node deleteAllOcc(Node head, int x) {
    if (head == null) return null;

    // Remove occurrences at the head of the list
    while (head != null && head.data == x) {
      head = head.next;
      if (head != null) {
        head.prev = null;
      }
    }

    // Traverse the list to remove other occurrences
    Node temp = head;
    while (temp != null) {
      if (temp.data == x) {
        Node prev = temp.prev;
        Node next = temp.next;

        if (prev != null) {
          prev.next = next;
        }
        if (next != null) {
          next.prev = prev;
        }
      }
      temp = temp.next;
    }

    return head;
  }

  static Node insertFirst(Node head, int val) {
    Node node = new Node(val);
    if (head == null) return node;
    node.next = head;
    head.prev = node;
    return node;
  }

  static Node insertLast(Node head, int val) {
    Node temp = head;
    if (head == null) return new Node(val);

    while (temp.next != null) {
      temp = temp.next;
    }
    Node node = new Node(val, temp, null);
    temp.next = node;
    return head;
  }

  static Node insertBeforeTail(Node head, int val) {
    if (head == null) return new Node(val);
    if (head.next == null) return insertFirst(head, val);

    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    Node prev = temp.prev;
    Node node = new Node(val, prev, temp);
    prev.next = node;
    temp.prev = node;
    return head;
  }

  static Node insertAtIndex(Node head, int val, int index) {
    // create node as we have to insert it
    Node node = new Node(val);
    if (index == 1) {
      // In the index is 1 that means we have to insert the element at head/start
      node.next = head;
      head.prev = node;

      head = node;
      return head;
    }

    // get temp and prev pointers for iteration prev is required as we have to insert element at the end of the list too
    Node temp = head;
    Node prev = null;

    int count = 0; // counter to keep track of the current index
    while (temp != null) {
      count++; // for 1 based indexing we use this at start of loop
      if (count == index) { // if matches index break out of loop
        break;
      }
      // move temp to next and prev to temp
      prev = temp;
      temp = temp.next;
    }

    // If we are inserting element at the last of DLL then we can return it here by adding element at last
    // As there is no need to set next of the Node node
    if (count + 1 == index) {
      node.prev = prev;
      prev.next = node;
      return head;
    }
    if (temp == null) {
      // If index is big then return head without doing any insertions
      return head;
    }

    // Set prev and next connections in appropriate manner
    node.prev = prev;
    prev.next = node;
    node.next = temp;
    temp.prev = node;

    return head;
  }

  static Node insertBeforeIndex(Node head, int val, int index) {
    Node node = new Node(val);
    Node temp = head;

    int cnt = 0;
    while (temp != null && cnt < index) {
      temp = temp.next;
      cnt++;
    }
    if (temp == null) return head;

    node.next = temp.next;
    node.prev = temp;

    if (temp.next != null) {
      temp.next.prev = node;
    }
    temp.next = node;
    return head;
  }

  static Node insertAfterIndex(Node head, int val, int index) {
    Node node = new Node(val);

    if (index == 0) {
      node.next = head;
      if (head != null) head.prev = node;
      return node;
    }
    Node temp = head;

    int cnt = 0;
    while (temp != null && cnt < index - 1) {
      temp = temp.next;
      cnt++;
    }
    // if (temp == null) return head;

    node.next = temp.next;
    node.prev = temp;

    if (temp.next != null) {
      temp.next.prev = node;
    }
    temp.next = node;
    return head;
  }

  public static void main(String args[]) {
    // System.out.println("konichiwa");
    // Node node = arrayToDLL(new int[] { 2, 3, 4, 5, 6, 7, 8 });
    // printDLL(node);

    // node = deleteFirst(node);
    // printDLL(node);

    // node = deleteLast(node);
    // printDLL(node);
    // printDLL(n);
    // Node n = new Node(99);
    // n = deleteFirst(n);
    // printDLL(n);

    // node = deleteIndex(node, 5);
    // printDLL(node);

    // node = deleteVal(node, 3);
    // printDLL(node);
    // node = insertFirst(node, 69);
    // printDLL(node);

    // node = insertLast(node, 68);
    // printDLL(node);

    // node = insertBeforeTail(node, 68);
    // printDLL(node);

    // node = insertBeforeIndex(node, 55, 8);
    // printDLL(node);
    //
    //
    // Node abc = arrayToDLL(new int[] { 1, 2, 3 });
    // abc = insertAtIndex(abc, 4, 4);
    // abc = insertAtIndex(abc, 1, 5);
    // abc = deleteIndex(abc, 1);
    // abc = deleteIndex(abc, 4);
    // printDLL(abc);

    Node abc = arrayToDLL(new int[] { 5, 4, 3, 2, 1 });
    abc = insertAfterIndex(abc, 5, 5);
    printDLL(abc);
  }
}

class Node {

  int data;
  Node prev;
  Node next;

  public Node(int val, Node prev, Node next) {
    this.data = val;
    this.next = next;
    this.prev = prev;
  }

  public Node(int val) {
    this.data = val;
    this.prev = null;
    this.next = null;
  }
}
