// Coin Change
/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
 */

import java.util.Arrays;

public class Leet322 {
  public static void main(String[] args) {
    System.out.println(coinChange(new int[] { 2 }, 3));
  }

  public static int coinChange(int[] coins, int amount) {
    int n = coins.length;
    int[][] dp = new int[n][amount + 1];
    for (int[] is : dp) {
      Arrays.fill(is, -1);
    }
    int result = function(n - 1, amount, coins, dp);
    return result >= (int) Math.pow(10, 9) ? -1 : result;
  }

  private static int function(int index, int amount, int[] coins, int[][] dp) {
    // if (index == 0)
    // if (amount % coins[0] == 0)
    // return amount / coins[0];
    // else
    // return (int) Math.pow(10, 9);

    if (amount == 0)
      return 0;
    if (index < 0)
      return (int) Math.pow(10, 9);

    if (dp[index][amount] != -1)
      return dp[index][amount];

    int notTake = function(index - 1, amount, coins, dp);
    int take = (int) Math.pow(10, 9);

    if (coins[index] <= amount)
      take = 1 + function(index, amount - coins[index], coins, dp);
    return dp[index][amount] = Math.min(notTake, take);
  }
}
