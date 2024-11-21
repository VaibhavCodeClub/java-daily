/**
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
The graph is represented as an adjacency list, where adj[i] contains a list of vertices that are directly reachable from vertex i. Specifically, adj[i][j] represents an edge from vertex i to vertex j.
 */
import java.util.*;

public class TopologicalSort {

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

        dir1.addEdge(3, 2);
        dir1.addEdge(0, 3);
        System.out.println("\nDirected Unweighted Graph");
        dir1.printDirected();

        System.out.println(topologicalSortDFS(dir1.adjList));
        System.out.println(topologicalSortBFS(dir1.adjList));
    }

    static ArrayList<Integer> topologicalSortDFS(
        ArrayList<ArrayList<Integer>> adj
    ) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) topoSort(i, visited, stack, adj);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }

    private static void topoSort(
        int node,
        boolean[] visited,
        Stack<Integer> stack,
        ArrayList<ArrayList<Integer>> adj
    ) {
        visited[node] = true;

        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) topoSort(neigh, visited, stack, adj);
        }
        stack.push(node);
    }

    static ArrayList<Integer> topologicalSortBFS(
        ArrayList<ArrayList<Integer>> adj
    ) {
        int n = adj.size();
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int num : adj.get(i)) inDegree[num]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) if (inDegree[i] == 0) queue.add(i);

        ArrayList<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ans.add(cur);

            for (int i : adj.get(cur)) {
                inDegree[i]--;
                if (inDegree[i] == 0) queue.add(i);
            }
        }
        return ans;
    }
}
