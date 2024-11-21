/**
* Given a binary grid of n*m. Find the distance of the nearest 1 in the grid for each cell.
The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the row number and column number of the current cell, and i2, j2 are the row number and column number of the nearest cell having value 1. There should be atleast one 1 in the grid.
*/
import java.util.*;

public class NearestCellHavingZeroOne {

    public static void main(String[] args) {
        int matrix[][] = nearest(
            new int[][] { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 0, 0 } }
        );
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static class Pair {

        int row, col, dist;

        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    static int[][] nearest(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] rep = grid;

        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) if (grid[i][j] == 1) {
                queue.add(new Pair(i, j, 0));
                rep[i][j] = 0;
                vis[i][j] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            int dist = queue.peek().dist;

            int dRow[] = { 0, 1, 0, -1 };
            int dCol[] = { 1, 0, -1, 0 };

            for (int i = 0; i < 4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if (
                    nRow >= 0 &&
                    nRow < n &&
                    nCol >= 0 &&
                    nCol < m &&
                    vis[nRow][nCol] != 1
                ) {
                    queue.add(new Pair(nRow, nCol, dist + 1));
                    rep[nRow][nCol] = dist + 1;
                    vis[nRow][nCol] = 1;
                }
            }
        }
        return rep;
    }
}
