import java.util.*;

public class AllInOneTraversals {

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

    allTraversals(node);
  }

  private static class Pair {

    Node node;
    int count;

    Pair(Node node, int count) {
      this.node = node;
      this.count = count;
    }
  }

  private static void allTraversals(Node root) {
    Stack<Pair> stack = new Stack<>();
    stack.push(new Pair(root, 1));

    List<Integer> pre = new ArrayList<>();
    List<Integer> in = new ArrayList<>();
    List<Integer> post = new ArrayList<>();

    if (root == null) return;

    while (!stack.isEmpty()) {
      Pair it = stack.pop();

      if (it.count == 1) {
        pre.add(it.node.val);
        it.count++;
        stack.push(it);

        if (it.node.left != null) stack.push(new Pair(it.node.left, 1));
      } else if (it.count == 2) {
        in.add(it.node.val);
        it.count++;
        stack.push(it);
        if (it.node.right != null) stack.push(new Pair(it.node.right, 1));
      } else {
        post.add(it.node.val);
      }
    }
    System.out.println(pre);
    System.out.println(in);
    System.out.println(post);
  }
}
