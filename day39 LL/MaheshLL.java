class Node {

  int data;
  Node next;

  Node(int data) {
    this.data = data;
  }

  Node(int data, Node next) {
    this.data = data;
    this.next = next;
  }
}

public class MaheshLL {

  static void printSLL(Node head) {
    Node temp = head;

    while (temp != null) {
      System.out.print(temp.data + " -> ");
      temp = temp.next;
    }
    System.out.println(" null");
  }

  public static void main(String[] args) {
    Node n = new Node(10);
    Node m = new Node(30);
    m.next = n;

    System.out.println(n.data);
    printSLL(m);
  }
}
