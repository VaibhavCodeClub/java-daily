/**
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
The graph is represented as an adjacency list, where adj[i] contains a list of vertices that are directly reachable from vertex i. Specifically, adj[i][j] represents an edge from vertex i to vertex j.
 */
import java.util.*;

public class CycleInDirectedGraph {

    private static class DirectedGraph {

        private ArrayList<ArrayList<Integer>> adjList;

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

    public static void main(String[] args) {
        int i = 4;
        DirectedGraph dir1 = new DirectedGraph(i);

        dir1.addEdge(0, 1);
        dir1.addEdge(1, 2);

        dir1.addEdge(2, 3);
        dir1.addEdge(3, 3);
        System.out.println("\nDirected Unweighted Graph");
        dir1.printDirected();

        System.out.println(isCyclic(i, dir1.adjList));
    }

    public static boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        boolean[] dfsVisited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (checkCycleDFS(i, visited, dfsVisited, adj)) return true;
            }
        }
        return false;
    }

    private static boolean checkCycleDFS(
        int i,
        boolean[] visited,
        boolean[] dfsVisited,
        ArrayList<ArrayList<Integer>> adj
    ) {
        visited[i] = true;
        dfsVisited[i] = true;

        for (int neighbour : adj.get(i)) {
            if (!visited[neighbour]) {
                if (
                    checkCycleDFS(neighbour, visited, dfsVisited, adj)
                ) return true;
            } else if (dfsVisited[neighbour]) return true;
        }
        dfsVisited[i] = false;
        return false;
    }
}
