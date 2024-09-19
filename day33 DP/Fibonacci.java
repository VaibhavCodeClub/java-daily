import java.util.Arrays;

public class Fibonacci {
  public static void main(String[] args) {
    int n = 8;
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println(fibo(n, dp));
    System.out.println(fibo1(n));
  }

  private static int fibo(int n, int[] dp) {
    if (n <= 1)
      return n;
    if (dp[n] != -1)
      return dp[n];
    return dp[n] = fibo(n - 1, dp) + fibo(n - 2, dp);
  }

  // Better approach is below for optimising both time and space
  private static int fibo1(int n) {

    int prev2 = 0;
    int prev = 1;
    for (int i = 2; i <= n; i++) {
      int cur = prev + prev2;
      prev2 = prev;
      prev = cur;
    }
    return prev;
  }
}