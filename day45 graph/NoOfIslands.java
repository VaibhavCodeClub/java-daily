/**
Number of Islands
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*/
import java.util.*;

public class NoOfIslands {

    private static class UndirectedGraph {

        private int[][] adjMatrix;

        public UndirectedGraph(int vertices) {
            adjMatrix = new int[vertices][vertices];
        }

        public void addEdge(int src, int dest) {
            adjMatrix[src][dest] = 1;
            adjMatrix[dest][src] = 1;
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
        UndirectedGraph graph = new UndirectedGraph(8);
        graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(3, 4);
        graph.addEdge(5, 4);
        graph.addEdge(6, 7);
        graph.printAdjMatrix();
        System.out.println(getTotalIslands(graph.adjMatrix));
    }

    private static class Pair {

        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int getTotalIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length, cnt = 0;
        int vis[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    cnt++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return cnt;
    }

    private static void bfs(int row, int col, int[][] vis, int[][] grid) {
        int n = grid.length, m = grid[0].length;
        vis[row][col] = 1;
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(row, col));

        while (!queue.isEmpty()) {
            int r = queue.peek().first;
            int c = queue.peek().second;

            queue.remove();

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int crow = r + i;
                    int ccol = c + j;

                    if (
                        crow >= 0 &&
                        crow < n &&
                        ccol >= 0 &&
                        ccol < m &&
                        vis[crow][ccol] == 0 &&
                        grid[crow][ccol] == 1
                    ) {
                        vis[crow][ccol] = 1;
                        queue.add(new Pair(crow, ccol));
                    }
                }
            }
        }
    }
}
