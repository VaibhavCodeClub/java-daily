import java.util.*;

public class BFS {

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

    System.out.println(bfs(root));
    System.out.println(levelOrder(root));
  }

  private static List<List<Integer>> bfs(Node root) {
    List<List<Integer>> ans = new LinkedList<>();
    if (root == null) return ans;

    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> sublList = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        if (queue.peek().left != null) queue.offer(queue.peek().left);
        if (queue.peek().right != null) queue.offer(queue.peek().right);
        sublList.add(queue.poll().val);
      }
      ans.add(sublList);
    }
    return ans;
  }

  private static List<Integer> levelOrder(Node root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) return ans;

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      Node curr = queue.poll();

      ans.add(curr.val);

      if (curr.left != null) queue.add(curr.left);
      if (curr.right != null) queue.add(curr.right);
    }
    return ans;
  }
}
