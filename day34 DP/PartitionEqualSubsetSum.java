import java.util.Arrays;

public class PartitionEqualSubsetSum {
  public static void main(String[] args) {
    System.out.println(canPartition(new int[] { 2, 3, 3, 3, 4, 5 }, 6));
  }

  private static boolean function(int index, int target, int[] arr, Boolean[][] dp) {
    if (target == 0)
      return true;
    if (index == 0)
      return arr[0] == target;

    if (dp[index][target] != null) {
      return dp[index][target];
    }
    boolean notTake = function(index - 1, target, arr, dp);
    boolean take = false;

    if (target >= arr[index])
      take = function(index - 1, target - arr[index], arr, dp);
    dp[index][target] = take || notTake;
    return dp[index][target];
  }


  private static boolean function2(int n, int target, int[] arr) {
    boolean[] prev = new boolean[target + 1];
    boolean[] cur = new boolean[target + 1];

    // Base case: a sum of 0 can always be achieved by taking no elements
    prev[0] = true;

    // If the first element is less than or equal to the target, we can achieve that sum
    if (arr[0] <= target) {
        prev[arr[0]] = true;
    }

    for (int i = 1; i < n; i++) {
        cur[0] = true; // A sum of 0 is always possible
        for (int j = 1; j <= target; j++) { // Loop should go up to target inclusive
            boolean notTake = prev[j];
            boolean take = false;

            if (j >= arr[i]) {
                take = prev[j - arr[i]];
            }

            cur[j] = take || notTake;
        }
        prev = Arrays.copyOf(cur, target + 1); // Copy cur into prev for the next iteration
    }

    return prev[target];
  }


  public static boolean canPartition(int[] arr, int n) {
    int sum = 0;
    for (int i : arr) {
      sum += i;
    }
    if (sum % 2 == 1)
      return false;
    Boolean[][] dp = new Boolean[n][sum / 2 + 1];
    for (Boolean[] booleans : dp) {
      Arrays.fill(booleans, null);
    }
    //return function(n - 1, sum / 2, arr, dp);
    return function2(n - 1, sum / 2, arr);
  }
}
