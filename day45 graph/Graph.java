import java.util.ArrayList;
import java.util.List;

public class Graph {

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

  private static class DirectedGraph {

    private List<List<Integer>> adjList;

    public DirectedGraph(int vertices) {
      adjList = new ArrayList<>();
      for (int i = 0; i < vertices; i++) {
        adjList.add(new ArrayList<>());
      }
    }

    public void addEdge(int src, int dest) {
      adjList.get(src).add(dest);
    }

    public void printDirected() {
      for (int i = 0; i < adjList.size(); i++) {
        System.out.print("Index " + i + ":");
        for (int num : adjList.get(i)) System.out.print(" -> " + num);
        System.out.println();
      }
    }
  }

  private static class WeightedGraph {

    private class Pair {

      int dest, weight;

      Pair(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
      }
    }

    private List<List<Pair>> adjList;

    public WeightedGraph(int vertices) {
      adjList = new ArrayList<>();
      for (int i = 0; i < vertices; i++) adjList.add(new ArrayList<>());
    }

    public void addEdge(int start, int dest, int weight) {
      adjList.get(start).add(new Pair(dest, weight));
      adjList.get(dest).add(new Pair(start, weight));
    }

    public void printWeighted() {
      for (int i = 0; i < adjList.size(); i++) {
        System.out.print("Vertex " + i + ":");
        for (Pair pair : adjList.get(i)) {
          System.out.print(" -> " + pair.dest + "," + pair.weight);
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

    DirectedGraph dir1 = new DirectedGraph(5);

    dir1.addEdge(0, 1);
    dir1.addEdge(1, 4);
    dir1.addEdge(1, 3);
    dir1.addEdge(0, 2);
    dir1.addEdge(2, 3);
    dir1.addEdge(4, 3);
    System.out.println("\nDirected Unweighted Graph");
    dir1.printDirected();

    WeightedGraph wei = new WeightedGraph(5);

    wei.addEdge(0, 1, 3);
    wei.addEdge(1, 4, 3);
    wei.addEdge(1, 3, 2);
    wei.addEdge(0, 2, 2);
    wei.addEdge(2, 3, 1);
    wei.addEdge(4, 3, 7);
    System.out.println("\nUndirected Weighted Graph");
    wei.printWeighted();
  }
}
