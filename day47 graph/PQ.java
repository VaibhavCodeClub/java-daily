import java.util.*;

public class PQ {

    private static class Pair {

        int dest, weight;

        Pair(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    private static class WeightedGraph {

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
        WeightedGraph wei = new WeightedGraph(5);

        wei.addEdge(0, 1, 3);
        wei.addEdge(1, 4, 3);
        wei.addEdge(1, 3, 2);
        wei.addEdge(0, 2, 2);
        wei.addEdge(2, 3, 1);
        wei.addEdge(4, 3, 7);
        System.out.println("\nUndirected Weighted Graph");
        wei.printWeighted();

        System.out.println(Arrays.toString(dijk(wei.adjList)));
    }

    private static int[] dijk(List<List<Pair>> adj) {
        int n = adj.size();
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.weight - b.weight
        );
        dist[0] = 0;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.dest;

            for (Pair neigh : adj.get(u)) {
                int v = neigh.dest;
                int w = neigh.weight;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        return dist;
    }
}
