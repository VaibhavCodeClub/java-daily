/*
Given a rod of length ‘N’ units. The rod can be cut into different sizes and each size has a cost associated with it. Determine the maximum cost obtained by cutting the rod and selling its pieces.
Note:
1. The sizes will range from 1 to ‘N’ and will be integers.
2. The sum of the pieces cut should be equal to ‘N’.
3. Consider 1-based indexing.
*/
import java.util.Arrays;

public class RodCutting {

  public static void main(String args[]) {
    System.out.print(cutRod(new int[] { 3, 5, 8, 9, 10, 17, 17, 20 }, 8));
  }

  public static int cutRod(int price[], int n) {
    int dp[][] = new int[n][n + 1];
    for (int[] arr : dp) {
      Arrays.fill(arr, -1);
    }

    return function(n - 1, n, price, dp);
  }

  private static int function(int index, int n, int[] price, int[][] dp) {
    if (index == 0) return n * price[0];
    if (dp[index][n] != -1) return dp[index][n];

    int notTake = function(index - 1, n, price, dp);
    int take = Integer.MIN_VALUE;

    if (index + 1 <= n) {
      take = price[index] + function(index, n - (index + 1), price, dp);
    }
    return dp[index][n] = Math.max(take, notTake);
  }
}
