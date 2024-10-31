/**
 * Binary Tree Implementation and three types of traversals
 */
import java.util.*;

public class BT {

  private static class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
    }
  }

  private static void preOrder(Node root) {
    if (root == null) return;
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  private static void inOrder(Node root) {
    if (root == null) return;
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }

  private static void postOrder(Node root) {
    if (root == null) return;
    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.data + " ");
  }

  public static void main(String[] args) {
    final Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    inOrder(root);
    System.out.println();
    preOrder(root);
    System.out.println();
    postOrder(root);
    System.out.println();

    List<List<Integer>> traversals = new ArrayList<>();
    List<Integer> inOrderResult = new ArrayList<>();
    List<Integer> preOrderResult = new ArrayList<>();
    List<Integer> postOrderResult = new ArrayList<>();

    inOrder2(root, inOrderResult);
    preOrder2(root, preOrderResult);
    postOrder2(root, postOrderResult);

    traversals.add(inOrderResult);
    traversals.add(preOrderResult);
    traversals.add(postOrderResult);

    System.out.println(traversals);
  }

  private static void preOrder2(Node root, List<Integer> result) {
    if (root == null) return;
    result.add(root.data);
    preOrder2(root.left, result);
    preOrder2(root.right, result);
  }

  private static void inOrder2(Node root, List<Integer> result) {
    if (root == null) return;
    inOrder2(root.left, result);
    result.add(root.data);
    inOrder2(root.right, result);
  }

  private static void postOrder2(Node root, List<Integer> result) {
    if (root == null) return;
    postOrder2(root.left, result);
    postOrder2(root.right, result);
    result.add(root.data);
  }
}
