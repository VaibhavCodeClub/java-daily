// Given an undirected graph with V vertices labelled from 0 to V-1 and E edges, check whether the graph contains any cycle or not. The Graph is represented as an adjacency list, where adj[i] contains all the vertices that are directly connected to vertex i.

// NOTE: The adjacency list represents undirected edges, meaning that if there is an edge between vertex i and vertex j, both j will be adj[i] and i will be in adj[j].
import java.util.*;

public class CycleInUndirectedGraph {

    private static class UndirectedGraph {

        private ArrayList<ArrayList<Integer>> adjList;

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
        UndirectedGraph graph2 = new UndirectedGraph(7);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(3, 4);
        graph2.addEdge(2, 5);
        graph2.addEdge(3, 6);
        graph2.addEdge(6, 0);
        graph2.addEdge(5, 0);

        System.out.println("Undirected Unweighted Graph");
        graph2.printGraph();

        System.out.println(isCycle(graph2.adjList));
        System.out.println(isCycleDFS(graph2.adjList));
    }

    static boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        boolean vis[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (checkForCycle(i, n, adj, vis)) return true;
            }
        }
        return false;
    }

    private static class Pair {

        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static boolean checkForCycle(
        int i,
        int n,
        ArrayList<ArrayList<Integer>> adj,
        boolean vis[]
    ) {
        vis[i] = true;
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(i, -1));

        while (!queue.isEmpty()) {
            int node = queue.peek().first;
            int prev = queue.peek().second;
            queue.remove();

            for (int num : adj.get(node)) {
                if (!vis[num]) {
                    vis[num] = true;
                    queue.add(new Pair(num, node));
                } else if (prev != num) return true;
            }
        }
        return false;
    }

    private static boolean isCycleDFS(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        boolean vis[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) if (dfs(i, -1, adj, vis)) return true;
        }
        return false;
    }

    private static boolean dfs(
        int node,
        int parent,
        ArrayList<ArrayList<Integer>> adj,
        boolean vis[]
    ) {
        vis[node] = true;
        for (int i : adj.get(node)) {
            if (!vis[i]) {
                if (dfs(i, node, adj, vis) == true) return true;
            } else if (i != parent) return true;
        }
        return false;
    }
}
