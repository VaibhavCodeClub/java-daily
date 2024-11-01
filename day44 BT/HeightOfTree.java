import java.util.*;

public class HeightOfTree {

  private static class Node {

    int val;
    Node left;
    Node right;

    public Node(int data) {
      this.val = data;
    }
  }

  public static void main(String[] args) {
    Node node = new Node(1);
    node.left = new Node(2);
    node.right = new Node(3);
    node.left.left = new Node(4);
    node.left.right = new Node(5);
    node.right.left = new Node(6);
    node.right.left.right = new Node(7);

    System.out.println(height(node));
    System.out.println(isBalanced(node));
  }

  private static int height(Node root) {
    if (root == null) return 0;

    return 1 + Math.max(height(root.left), height(root.right));
  }

  private static boolean isBalanced(Node root) {
    return dfsHeight(root) != -1;
  }

  private static int dfsHeight(Node root) {
    if (root == null) return 0;

    int left = dfsHeight(root.left);
    if (left == -1) return -1;

    int right = dfsHeight(root.right);
    if (right == -1) return -1;

    if (Math.abs(left - right) > 1) return -1;
    return 1 + Math.max(left, right);
  }
}
