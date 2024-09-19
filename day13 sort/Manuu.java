public class Manuu {

  public static int maxScore(int[] arr) {
    int n = arr.length;
    if (n == 0) return 0;
    if (n == 1) return arr[0];

    // dp[i] will store the max score possible up to index i
    int[] dp = new int[n];

    dp[0] = arr[0];
    dp[1] = Math.max(arr[0], arr[1]);

    for (int i = 2; i < n; i++) {
      // Max score at index i would be either not picking arr[i] or picking it
      dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
    }

    // The result will be in dp[n-1] as it contains the max score for the whole array
    return dp[n - 1];
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 9, 4, 5, 0, 4, 6 };
    System.out.println("Maximum score: " + maxScore(arr));

    int[] arr2 = { 1, 2, 3 };
    System.out.println("Maximum score: " + maxScore(arr2));
  }
}
