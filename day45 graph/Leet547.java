/*
Number of Provinces
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
Return the total number of provinces.
*/
import java.util.*;

public class Leet547 {

  private static class UndirectedGraph {

    private List<List<Integer>> adjList;
    private int[][] adjMatrix;

    public UndirectedGraph(int vertices) {
      adjList = new ArrayList<>(vertices);
      adjMatrix = new int[vertices][vertices];

      for (int i = 0; i < vertices; i++) adjList.add(new ArrayList<>());
    }

    public void addEdge(int src, int dest) {
      adjList.get(src).add(dest);
      adjList.get(dest).add(src);
      adjMatrix[src][dest] = 1;
      adjMatrix[dest][src] = 1;
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

    public void printAdjMatrix() {
      for (int[] arr : adjMatrix) {
        for (int i : arr) {
          System.out.print(i + "  ");
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
    // graph2.printGraph();
    graph2.printAdjMatrix();
    System.out.println(findCircleNum(graph2.adjMatrix));

    UndirectedGraph graph = new UndirectedGraph(8);
    graph.addEdge(0, 1);
    graph.addEdge(2, 1);
    graph.addEdge(3, 4);
    graph.addEdge(5, 4);
    graph.addEdge(6, 7);

    System.out.println(findCircleNum(graph.adjMatrix));
  }

  public static int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    int ans = 0;
    boolean visited[] = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        ans++;
        queue.add(i);
        bfs(queue, isConnected, visited);
      }
    }
    return ans;
  }

  static void bfs(Queue<Integer> queue, int[][] adj, boolean[] visited) {
    while (!queue.isEmpty()) {
      int curr = queue.poll();
      visited[curr] = true;
      for (int i = 0; i < adj.length; i++) {
        if (adj[curr][i] == 1 && !visited[i]) {
          visited[i] = true;
          queue.add(i);
        }
      }
    }
  }

  public static int findCircleNumDFS(int[][] isConnected) {
    int n = isConnected.length;
    int ans = 0;
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        ans++;
        dfs(i, isConnected, visited);
      }
    }
    return ans;
  }

  static void dfs(int node, int[][] adj, boolean[] visited) {
    visited[node] = true;
    for (int i = 0; i < adj.length; i++) {
      if (adj[node][i] == 1 && !visited[i]) {
        dfs(i, adj, visited);
      }
    }
  }
}
