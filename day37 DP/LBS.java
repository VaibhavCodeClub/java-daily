// Longest Bitonic Sequence
/*
A Bitonic Sequence is a sequence of numbers that is first strictly increasing and then strictly decreasing.
A strictly ascending order sequence is also considered bitonic, with the decreasing part as empty, and same for a strictly descending order sequence.
For example, the sequences [1, 3, 5, 3, 2], [1, 2, 3, 4] are bitonic, whereas the sequences [5, 4, 1, 4, 5] and [1, 2, 2, 3] are not.
You are given an array 'arr' consisting of 'n' positive integers.
Find the length of the longest bitonic subsequence of 'arr'.
Example :
Input: 'arr' = [1, 2, 1, 2, 1]
Output: 3
Explanation: The longest bitonic subsequence for this array will be [1, 2, 1]. Please note that [1, 2, 2, 1] is not a valid bitonic subsequence, because the consecutive 2's are neither strictly increasing, nor strictly decreasing.
*/
import java.util.Arrays;

public class LBS {

  public static void main(String args[]) {
    System.out.println(
      longestBitonicSequence(new int[] { 1, 11, 2, 10, 4, 5, 2, 1 }, 8)
    );
    System.out.print(
      longestBitonicSequence2(new int[] { 1, 11, 2, 10, 4, 5, 2, 1 }, 8)
    );
  }

  public static int longestBitonicSequence(int[] arr, int n) {
    // Mountain / Just increasing / Just decreasing
    int[] dp = new int[n];
    int[] dp2 = new int[n];

    int ans = 1;
    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      for (int prev = 0; prev < i; prev++) if (
        arr[prev] < arr[i] && 1 + dp[prev] > dp[i]
      ) {
        dp[i] = 1 + dp[prev];
      }
    }
    for (int i = n - 1; i >= 0; i--) {
      dp2[i] = 1;
      for (int next = i + 1; next < n; next++) {
        if (arr[next] < arr[i] && dp2[next] + 1 > dp2[i]) {
          dp2[i] = dp2[next] + 1;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      ans = Math.max(ans, dp[i] + dp2[i] - 1);
    }
    return ans;
  }

  public static int longestBitonicSequence2(int[] arr, int n) {
    int[] dp = new int[n];
    int[] dp2 = new int[n];

    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      dp2[i] = 1;
    }

    for (int i = 0; i < n; i++) {
      for (int prev = 0; prev < i; prev++) {
        if (arr[prev] < arr[i] && 1 + dp[prev] > dp[i]) {
          dp[i] = 1 + dp[prev];
        }
      }
    }

    for (int i = n - 1; i >= 0; i--) {
      for (int next = i + 1; next < n; next++) {
        if (arr[next] < arr[i] && dp2[next] + 1 > dp2[i]) {
          dp2[i] = dp2[next] + 1;
        }
      }
    }

    int maxLength = 0;

    for (int i = 0; i < n; i++) {
      if (dp[i] > 1 && dp2[i] > 1) {
        maxLength = Math.max(maxLength, dp[i] + dp2[i] - 1);
      }
    }
    return maxLength;
  }
}
