import java.util.*;

public class DiameterOfBT {

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
    node.right.left.right.left = new Node(8);

    diameter(node);
    System.out.println(max);

    System.out.println(maxPathSum(node));
  }

  static int max;

  static int diameter(Node node) {
    if (node == null) return 0;

    int leftHeight = diameter(node.left);
    int rightHeight = diameter(node.right);

    max = Math.max(max, leftHeight + rightHeight);
    return Math.max(leftHeight, rightHeight) + 1;
  }

  static int maxi;

  static int maxPathSum(Node root) {
    maxi = Integer.MIN_VALUE;
    maxPathSumHelper(root);
    return maxi;
  }

  static int maxPathSumHelper(Node root) {
    if (root == null) return 0;

    int leftHeight = Math.max(maxPathSumHelper(root.left), 0);
    int rightHeight = Math.max(maxPathSumHelper(root.right), 0);

    maxi = Math.max(maxi, leftHeight + rightHeight + root.val);

    return root.val + Math.max(leftHeight, rightHeight);
  }
}
