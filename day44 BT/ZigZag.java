import java.util.*;

public class ZigZag {

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

    System.out.println(zigzagLevelOrder(node));
    System.out.println(zigZagTraversal(node));
  }

  public static List<List<Integer>> zigzagLevelOrder(Node root) {
    Queue<Node> queue = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;

    int flag = 0;
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> temp = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        if (queue.peek().left != null) {
          queue.add(queue.peek().left);
        }
        if (queue.peek().right != null) {
          queue.add(queue.peek().right);
        }
        temp.add(queue.poll().val);
      }
      if (flag == 1) {
        Collections.reverse(temp);
        flag = 0;
      } else {
        flag = 1;
      }
      ans.add(temp);
    }
    return ans;
  }

  public static ArrayList<Integer> zigZagTraversal(Node root) {
    Queue<Node> queue = new LinkedList<>();
    ArrayList<Integer> ans = new ArrayList<>();
    if (root == null) return ans;

    int flag = 0;
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> temp = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        if (queue.peek().left != null) {
          queue.add(queue.peek().left);
        }
        if (queue.peek().right != null) {
          queue.add(queue.peek().right);
        }
        temp.add(queue.poll().val);
      }
      if (flag == 1) {
        Collections.reverse(temp);
        flag = 0;
      } else {
        flag = 1;
      }
      for (int i : temp) ans.add(i);
    }
    return ans;
  }
}
