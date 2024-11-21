import java.util.*;

public class ShortestPathInUndirectedGraph {

    private static class UndirectedGraph {

        private List<List<Integer>> adjList;
        private int[][] adjMatrix;

        public UndirectedGraph(int vertices) {
            adjList = new ArrayList<>(vertices);
            adjMatrix = new int[vertices + 1][vertices + 1];

            for (int i = 0; i <= vertices; i++) adjList.add(new ArrayList<>());
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
        int v = 8, e = 9;
        UndirectedGraph graph2 = new UndirectedGraph(v);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(1, 4);
        graph2.addEdge(2, 5);
        graph2.addEdge(3, 8);
        graph2.addEdge(4, 6);
        graph2.addEdge(6, 7);
        graph2.addEdge(5, 8);
        graph2.addEdge(8, 7);

        System.out.println("Undirected Unweighted Graph");
        graph2.printGraph();

        System.out.println(parent(graph2.adjMatrix, v, e, 1, 8));
    }

    public static LinkedList<Integer> parent(
        int[][] edges,
        int n,
        int m,
        int s,
        int t
    ) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i <= n; i++) for (int j = 1; j <= n; j++) if (
            edges[i][j] == 1
        ) adj.get(i).add(j);

        boolean[] visited = new boolean[n + 1];
        int parent[] = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        parent[s] = -1;

        visited[s] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int neigh : adj.get(curr)) {
                if (!visited[neigh]) {
                    queue.add(neigh);
                    parent[neigh] = curr;
                    visited[neigh] = true;
                    if (neigh == t) {
                        break;
                    }
                }
            }
        }
        LinkedList<Integer> path = new LinkedList<>();
        for (int i = t; i != -1; i = parent[i]) path.addFirst(i);
        if (path.getFirst() != s) {
            return new LinkedList<>();
        }
        return path;
    }
}
