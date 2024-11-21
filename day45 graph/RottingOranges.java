/**
LeetCode 994. Rotting Oranges
You are given an m x n grid where each cell can have one of three values:

    0 representing an empty cell,
    1 representing a fresh orange, or
    2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
*/
import java.util.*;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = new int[][] { { 0, 1, 2 }, { 0, 1, 1 }, { 2, 1, 1 } };
        System.out.println(orangesRotting(grid));
    }

    static class Pair {

        int row, col, time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int n = grid.length, m = grid[0].length, time = 0, freshCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                } else if (grid[i][j] == 1) freshCount++;
            }
        }

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int curRow = curr.row, curCol = curr.col;
            time = curr.time;
            if (curRow - 1 >= 0 && grid[curRow - 1][curCol] == 1) {
                queue.add(new Pair(curRow - 1, curCol, time + 1));
                grid[curRow - 1][curCol] = 2;
                freshCount--;
            }
            if (curRow + 1 < n && grid[curRow + 1][curCol] == 1) {
                queue.add(new Pair(curRow + 1, curCol, time + 1));
                grid[curRow + 1][curCol] = 2;
                freshCount--;
            }
            if (curCol - 1 >= 0 && grid[curRow][curCol - 1] == 1) {
                queue.add(new Pair(curRow, curCol - 1, time + 1));
                grid[curRow][curCol - 1] = 2;
                freshCount--;
            }
            if (curCol + 1 < m && grid[curRow][curCol + 1] == 1) {
                queue.add(new Pair(curRow, curCol + 1, time + 1));
                grid[curRow][curCol + 1] = 2;
                freshCount--;
            }
        }
        return freshCount == 0 ? time : -1;
    }
}
