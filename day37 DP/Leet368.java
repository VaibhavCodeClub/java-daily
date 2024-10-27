// Largest Divisible Subset
/*
Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
    answer[i] % answer[j] == 0, or
    answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet368 {

  public static void main(String args[]) {
    System.out.print(largestDivisibleSubset(new int[] { 1, 2, 3 }));
  }

  public static List<Integer> largestDivisibleSubset(int[] arr) {
    int n = arr.length;
    int[] dp = new int[n], hash = new int[n];
    Arrays.fill(dp, 1);

    int max = 1;
    int lastIndex = 0;
    Arrays.sort(arr);
    for (int i = 0; i < n; i++) {
      hash[i] = i;
      for (int prev = 0; prev < i; prev++) {
        if (arr[i] % arr[prev] == 0 && 1 + dp[prev] > dp[i]) {
          dp[i] = 1 + dp[prev];
          hash[i] = prev;
        }
      }
      if (dp[i] > max) {
        max = dp[i];
        lastIndex = i;
      }
    }
    List<Integer> temp = new ArrayList<>();
    temp.add(0, arr[lastIndex]);
    while (hash[lastIndex] != lastIndex) {
      lastIndex = hash[lastIndex];
      temp.add(0, arr[lastIndex]);
    }
    return temp;
  }
}
