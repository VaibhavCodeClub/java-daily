import java.util.*;

public class DFS {

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

    System.out.println(dfsOfGraph(graph2.adjList));
  }

  static ArrayList<Integer> dfsOfGraph(List<List<Integer>> adj) {
    ArrayList<Integer> ans = new ArrayList<>();
    boolean vis[] = new boolean[adj.size()];

    return dfsHelper(0, adj, ans, vis);
  }

  static ArrayList<Integer> dfsHelper(
    int node,
    List<List<Integer>> adj,
    ArrayList<Integer> ans,
    boolean[] vis
  ) {
    vis[node] = true;
    ans.add(node);

    for (int i : adj.get(node)) {
      if (!vis[i]) {
        dfsHelper(i, adj, ans, vis);
      }
    }
    return ans;
  }
}
