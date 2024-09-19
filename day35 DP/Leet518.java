// Coin Change II
/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.
*/
import java.util.Arrays;

public class Leet518 {

  public static void main(String args[]) {
    System.out.print(change(5, new int[] { 1, 2, 5 }));
  }

  public static int change(int amount, int[] coins) {
    int[][] dp = new int[coins.length][amount + 1];
    for (int[] arr : dp) {
      Arrays.fill(arr, -1);
    }
    return function(coins.length - 1, amount, coins, dp);
  }

  private static int function(int index, int target, int[] coins, int[][] dp) {
    if (index == 0) return target % coins[0] == 0 ? 1 : 0;
    if (dp[index][target] != -1) return dp[index][target];
    int notTake = function(index - 1, target, coins, dp);

    int take = 0;
    if (coins[index] <= target) take = function(
      index,
      target - coins[index],
      coins,
      dp
    );

    return dp[index][target] = take + notTake;
  }
}
