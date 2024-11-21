/**
Given a Weighted Directed Acyclic Graph (DAG) and a source vertex s in it, find the longest distances from s to all other vertices in the given graph. Return the distance array,  in the distance array instead of passing INF you need to have INT_MIN driver will automatically update it to INF.
 */
import java.util.*;

public class LongestPathInDAG {

    // Edge class to represent a directed edge with destination and weight
    private static class Edge {

        int dest; // Destination node
        int weight; // Weight of the edge

        // Constructor to initialize the edge
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int v = 6; // Number of vertices
        int e = 9; // Number of edges
        // Define edges in the format: {source, destination, weight}
        System.out.println(
            Arrays.toString(
                longestPathInDAG(
                    v,
                    e,
                    new int[][] {
                        { 0, 1, 5 },
                        { 0, 2, 3 },
                        { 1, 2, 2 },
                        { 1, 3, 6 },
                        { 2, 3, 7 },
                        { 2, 4, 4 },
                        { 2, 5, 2 },
                        { 3, 4, -1 },
                        { 4, 5, -2 },
                    }
                )
            )
        );
    }

    // Method to print the adjacency list of the graph
    private static void printAdj(List<List<Edge>> adjList) {
        for (int i = 0; i < adjList.size(); i++) {
            List<Edge> edges = adjList.get(i); // Get edges for the current node
            System.out.print("Node " + i + ":");
            // Check if there are edges to display
            if (edges.isEmpty()) {
                System.out.print(""); // No edges for this node
            } else {
                // Print all edges for the current node
                for (Edge e : edges) {
                    System.out.print(" -> " + e.dest + "," + e.weight);
                }
            }
            System.out.println(); // Move to the next line after printing edges
        }
    }

    // Method to find the longest path in a Directed Acyclic Graph (DAG)
    public static int[] longestPathInDAG(int n, int m, int[][] edges) {
        int source = 0; // Starting node for shortest path calculation
        List<List<Edge>> adjList = new ArrayList<>(); // Adjacency list representation of the graph

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>()); // Create a new list for each node
        }

        // Build the adjacency list from the edge list
        for (int i = 0; i < m; i++) {
            int src = edges[i][0]; // Source node
            int dest = edges[i][1]; // Destination node
            int weight = edges[i][2]; // Weight of the edge
            adjList.get(src).add(new Edge(dest, weight)); // Add the edge to the adjacency list
        }
        printAdj(adjList); // Print the adjacency list for debugging

        boolean[] visited = new boolean[n]; // Track visited nodes during DFS
        Stack<Integer> stack = new Stack<>(); // Stack to store the topological order of nodes

        // Perform DFS for topological sorting
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsTopo(i, visited, stack, adjList); // Call DFS for unvisited nodes
            }
        }

        int[] ans = new int[n]; // Array to store longest distances from the source
        Arrays.fill(ans, Integer.MIN_VALUE); // Initialize distances to -infinity
        ans[source] = 0; // Distance to the source from itself is 0

        // Process nodes in topological order
        while (!stack.isEmpty()) {
            int top = stack.pop(); // Get the next node in topological order

            // Relax the edges for the current node
            if (ans[top] != Integer.MIN_VALUE) { // Only process if the node is reachable
                for (Edge edge : adjList.get(top)) {
                    // Update the longest distance to the destination node if a longer path is found
                    if (ans[top] + edge.weight > ans[edge.dest]) {
                        ans[edge.dest] = ans[top] + edge.weight; // Relaxation step
                    }
                }
            }
        }
        return ans; // Return the array of longest distances
    }

    // DFS method for topological sorting
    private static void dfsTopo(
        int node,
        boolean[] visited,
        Stack<Integer> stack,
        List<List<Edge>> adjList
    ) {
        visited[node] = true; // Mark the current node as visited
        for (Edge neighbour : adjList.get(node)) { // Iterate through all adjacent nodes
            if (!visited[neighbour.dest]) { // If the neighbor is not visited
                dfsTopo(neighbour.dest, visited, stack, adjList); // Recur for the neighbor
            }
        }
        stack.push(node); // Push the current node to the stack after visiting all its neighbors
    }
}
