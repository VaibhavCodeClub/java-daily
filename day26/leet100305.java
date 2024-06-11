// Find the N-th Value After K Seconds
/*
You are given two integers n and k.

Initially, you start with an array a of n integers where a[i] = 1 for all 0 <= i <= n - 1. After each second, you simultaneously update each element to be the sum of all its preceding elements plus the element itself. For example, after one second, a[0] remains the same, a[1] becomes a[0] + a[1], a[2] becomes a[0] + a[1] + a[2], and so on.

Return the value of a[n - 1] after k seconds.

Since the answer may be very large, return it modulo 109 + 7.
*/

import java.util.Arrays;

public class leet100305 {
  public static void main(String[] args) {
    System.out.println(valueAfterKSeconds(5, 3));
  }

  public static int valueAfterKSeconds(int n, int k) {
    // Modulo constant
    int MOD = 1_000_000_007;

    // Initialize the array with all 1s
    int[] a = new int[n];
    Arrays.fill(a, 1);

    // Temporary array to hold the previous state
    int[] arrPrev = new int[n];
    Arrays.fill(arrPrev, 1);

    // Simulate for k seconds
    for (int sec = 1; sec <= k; sec++) {
      // Compute the new state based on the previous state
      for (int i = 1; i < n; i++) {
        a[i] = (a[i - 1] + arrPrev[i]) % MOD;
      }
      // Update the previous state array
      System.arraycopy(a, 0, arrPrev, 0, n);
    }

    // Return the value at index n-1 after k seconds
    return a[n - 1];

  }
}
