import java.util.*;

public class Dijkstras {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(0, 1, 5)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 8)));
        adj.add(new ArrayList<>(Arrays.asList(1, 2, 9)));
        adj.add(new ArrayList<>(Arrays.asList(1, 3, 2)));
        adj.add(new ArrayList<>(Arrays.asList(2, 3, 6)));

        System.out.println(dijkstra(adj, 4, 5, 0));
    }

    private static class Pair {

        int dest, weight;

        Pair(int i, int j) {
            dest = i;
            weight = j;
        }
    }

    public static ArrayList<Integer> dijkstra(
        ArrayList<ArrayList<Integer>> vec,
        int vertices,
        int edges,
        int source
    ) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> arr : vec) {
            int src = arr.get(0);
            int dest = arr.get(1);
            int weight = arr.get(2);

            adj.get(src).add(new Pair(dest, weight));
            adj.get(dest).add(new Pair(src, weight));
        }

        int dist[] = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (x, y) -> x.weight - y.weight
        );
        pq.add(new Pair(source, 0));

        dist[source] = 0;
        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().dest;
            int distance = pq.peek().weight;
            pq.remove();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int neighDist = adj.get(node).get(i).weight;
                int adjNode = adj.get(node).get(i).dest;

                if (distance + neighDist < dist[adjNode]) {
                    dist[adjNode] = distance + neighDist;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int d : dist) {
            result.add(d == Integer.MAX_VALUE ? -1 : d);
        }

        return result;
    }
}
