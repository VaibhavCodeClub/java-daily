/*
There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.
For Example

If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20.

 */

import java.util.Arrays;

public class FrogJump {
  public static void main(String[] args) {
    System.out.println(frogJump(8, new int[] { 7, 4, 4, 2, 6, 6, 3, 4 }));
    System.out.println(frogJump2(8, new int[] { 7, 4, 4, 2, 6, 6, 3, 4 }));
    System.out.println(frogJump(6, new int[] { 4, 8, 3, 10, 4, 4 }));
    System.out.println(frogJump3(6, new int[] { 4, 8, 3, 10, 4, 4 }));
  }

  public static int frogJump(int n, int heights[]) {
    int dp[] = new int[n];
    Arrays.fill(dp, -1);

    return func(n - 1, heights, dp);
  }

  private static int func(int index, int arr[], int dp[]) {
    if (index == 0)
      return 0;

    if (dp[index] != -1)
      return dp[index];

    int left = func(index - 1, arr, dp) + Math.abs(arr[index] - arr[index - 1]);

    int right = Integer.MAX_VALUE;
    if (index > 1)
      right = func(index - 2, arr, dp) + Math.abs(arr[index] - arr[index - 2]);
    return dp[index] = Math.min(left, right);
  }

  // Better apparoach is below Tabular
  // No stack space for recursion calls at all
  public static int frogJump2(int n, int heights[]) {
    int dp[] = new int[n];
    dp[0] = 0;

    for (int i = 1; i < dp.length; i++) {

      int left = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
      int right = Integer.MAX_VALUE;

      if (i > 1)
        right = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);

      dp[i] = Math.min(left, right);
    }
    return dp[n - 1];
  }

  // Below is more better spaced approach which eliminates the need of dp array
  // too
  public static int frogJump3(int n, int heights[]) {
    int prev = 0;
    int prev2 = 0;

    for (int i = 1; i < n; i++) {
      int left = prev + Math.abs(heights[i] - heights[i - 1]);
      int right = Integer.MAX_VALUE;
      if (i > 1)
        right = prev2 + Math.abs(heights[i] - heights[i - 2]);
      int cur = Math.min(left, right);
      prev2 = prev;
      prev = cur;
    }
    return prev;
  }
}
