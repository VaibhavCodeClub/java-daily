// Check if Grid Satisfies Conditions
/*
You are given a 2D matrix grid of size m x n. You need to check if each cell grid[i][j] is:

    Equal to the cell below it, i.e. grid[i][j] == grid[i + 1][j] (if it exists).
    Different from the cell to its right, i.e. grid[i][j] != grid[i][j + 1] (if it exists).

Return true if all the cells satisfy these conditions, otherwise, return false.
*/

public class leet100299 {
  public static void main(String[] args) {
    System.out.println(satisfiesConditions(new int[][] { { 1 }, { 2 }, { 3 } }));
  }

  public static boolean satisfiesConditions(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (i < grid.length - 1 && j < grid[0].length - 1) {
          int a = grid[i][j], b = grid[i + 1][j], c = grid[i][j + 1];
          if (a != b || a == c) {
            return false;
          }
        }
        if (i == grid.length - 1 && j < grid[0].length - 1) {
          int a = grid[i][j], c = grid[i][j + 1];
          if (a == c) {
            return false;
          }
        }
        if (j == grid[0].length - 1 && i < grid.length - 1) {
          int a = grid[i][j], b = grid[i + 1][j];
          if (a != b) {
            return false;
          }
        }
      }
    }
    return true;
  }

}
