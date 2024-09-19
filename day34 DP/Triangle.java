/*
You are given a triangular array/list 'TRIANGLE'. Your task is to return the minimum path sum to reach from the top to the bottom row.

The triangle array will have N rows and the i-th row, where 0 <= i < N will have i + 1 elements.

You can move only to the adjacent number of row below each step. For example, if you are at index j in row i, then you can move to i or i + 1 index in row j + 1 in each step.
For Example :

If the array given is 'TRIANGLE' = [[1], [2,3], [3,6,7], [8,9,6,1]] the triangle array will look like:

1
2,3
3,6,7
8,9,6,10

For the given triangle array the minimum sum path would be 1->2->3->8. Hence the answer would be 14.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
  public static void main(String[] args) {
    System.out.println(minimumPathSum(new int[][] { { 1 }, { 2, 3 }, { 3, 6, 7 }, { 8, 9, 6, 10 } }, 4));
    List<List<Integer>> triangle = new ArrayList<>();
    triangle.add(Arrays.asList(1));
    triangle.add(Arrays.asList(2, 3));
    triangle.add(Arrays.asList(3, 6, 7));
    triangle.add(Arrays.asList(8, 9, 6, 10));

    System.out.println(minimumTotal(triangle));
  }

  public static int minimumPathSum(int[][] triangle, int n) {
    int[][] dp = new int[n][n];
    for (int[] is : dp) {
      Arrays.fill(is, -1);
    }

    return function(0, 0, n, triangle, dp);
  }

  private static int function(int i, int j, int n, int[][] triangle, int[][] dp) {
    if (i == n - 1)
      return triangle[i][j];
    if (dp[i][j] != -1)
      return dp[i][j];

    int down = triangle[i][j] + function(i + 1, j, n, triangle, dp);
    int diagonal = triangle[i][j] + function(i + 1, j + 1, n, triangle, dp);

    return dp[i][j] = Math.min(down, diagonal);
  }

  private static int function2(int i, int j, int n, List<List<Integer>> triangle, int[][] dp) {
    if (i == n - 1)
      return triangle.get(i).get(j);
    if (dp[i][j] != -1)
      return dp[i][j];

    int down = triangle.get(i).get(j) + function2(i + 1, j, n, triangle, dp);
    int diagonal = triangle.get(i).get(j) + function2(i + 1, j + 1, n, triangle, dp);

    return dp[i][j] = Math.min(down, diagonal);
  }

  public static int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[][] dp = new int[n][n];
    for (int[] is : dp) {
      Arrays.fill(is, -1);
    }

    return function2(0, 0, n, triangle, dp);
  }
}
