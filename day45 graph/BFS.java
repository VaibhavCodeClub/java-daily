import java.util.*;

public class BFS {

  private static class UndirectedGraph {

    private List<List<Integer>> adjList;

    public UndirectedGraph(int vertices) {
      adjList = new ArrayList<>(vertices);
      for (int i = 0; i < vertices; i++) adjList.add(new ArrayList<>());
    }

    public void addEdge(int src, int dest) {
      adjList.get(src).add(dest);
      adjList.get(dest).add(src);
    }

    public void printGraph() {
      for (int i = 0; i < adjList.size(); i++) {
        System.out.print("Vertex " + i + ":");
        for (int j : adjList.get(i)) {
          System.out.print(" -> " + j);
        }
        System.out.println();
      }
    }
  }

  public static void main(String[] args) {
    UndirectedGraph graph2 = new UndirectedGraph(5);
    graph2.addEdge(0, 1);
    graph2.addEdge(0, 4);
    graph2.addEdge(1, 4);
    graph2.addEdge(1, 3);
    graph2.addEdge(1, 2);
    graph2.addEdge(4, 3);
    graph2.addEdge(2, 3);

    System.out.println("Undirected Unweighted Graph");
    graph2.printGraph();

    System.out.println(bfs(graph2.adjList));
  }

  static List<Integer> bfs(List<List<Integer>> adj) {
    int n = adj.size();

    List<Integer> ans = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    boolean visited[] = new boolean[n];

    queue.add(0);
    visited[0] = true;

    while (!queue.isEmpty()) {
      int curr = queue.poll();
      ans.add(curr);

      for (int i : adj.get(curr)) {
        if (!visited[i]) {
          visited[i] = true;
          queue.add(i);
        }
      }
    }
    return ans;
  }
}
