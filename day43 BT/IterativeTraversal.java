import java.util.*;

public class IterativeTraversal {

  private static class Node {

    int val;
    Node left;
    Node right;

    public Node(int data) {
      this.val = data;
    }
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.right.left = new Node(5);

    preOrder(root);
    inOrder(root);
    postOrder(root);

    Node node = new Node(1);
    node.left = new Node(2);
    node.right = new Node(3);
    node.left.left = new Node(4);
    node.left.right = new Node(5);
    node.right.left = new Node(6);
    node.right.left.right = new Node(7);

    postUsingSingleStack(node);
  }

  private static void preOrder(Node root) {
    if (root == null) return;
    Stack<Node> stack = new Stack<>();

    stack.push(root);
    while (!stack.isEmpty()) {
      Node curr = stack.pop();
      System.out.print(curr.val + " ");

      if (curr.right != null) stack.push(curr.right);
      if (curr.left != null) stack.push(curr.left);
    }
    System.out.println();
  }

  private static void inOrder(Node root) {
    if (root == null) return;
    Stack<Node> stack = new Stack<>();
    Node node = root;

    while (true) {
      if (node != null) {
        stack.push(node);
        node = node.left;
      } else {
        if (stack.isEmpty()) break;
        node = stack.pop();
        System.out.print(node.val + " ");
        node = node.right;
      }
    }
    System.out.println();
  }

  private static void postOrder(Node root) {
    if (root == null) return;
    Stack<Node> st1 = new Stack<>();
    Stack<Node> st2 = new Stack<>();

    st1.push(root);
    while (!st1.isEmpty()) {
      root = st1.pop();
      st2.add(root);

      if (root.left != null) st1.push(root.left);
      if (root.right != null) st1.push(root.right);
    }
    while (!st2.isEmpty()) System.out.print(st2.pop().val + " ");
    System.out.println();
  }

  private static void postUsingSingleStack(Node root) {
    if (root == null) return;

    Stack<Node> stack = new Stack<>();
    Node lastVisited = null;

    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      Node peekNode = stack.peek();
      if (peekNode.right == null || peekNode.right == lastVisited) {
        System.out.print(peekNode.val + " ");
        lastVisited = stack.pop();
      } else {
        root = peekNode.right;
      }
    }
  }
}
