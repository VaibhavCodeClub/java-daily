// Most Profit Assigning Work
/*
You have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:

    difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
    worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most worker[j]).

Every worker can be assigned at most one job, but one job can be completed multiple times.

    For example, if three workers attempt the same job that pays $1, then the total profit will be $3. If a worker cannot complete any job, their profit is $0.

Return the maximum profit we can achieve after assigning the workers to the jobs.
*/

import java.util.Arrays;

public class leet826 {
  public static void main(String[] args) {
    System.out.println(
        maxProfitAssignment(new int[] { 2, 4, 6, 8, 10 }, new int[] { 10, 20, 30, 40, 50 }, new int[] { 4, 5, 6, 7 }));
  }

  public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    int n = difficulty.length, m = worker.length;
    int maxEl = Arrays.stream(difficulty).max().getAsInt();
    int[] dp = new int[maxEl + 1];
    for (int i = 0; i < n; i++) {
      dp[difficulty[i]] = Math.max(dp[difficulty[i]], profit[i]);
    }
    for (int i = 1; i <= maxEl; i++) {
      dp[i] = Math.max(dp[i], dp[i - 1]);
    }
    int profSum = 0;
    for (int i = 0; i < m; i++) {
      if (worker[i] <= maxEl) {
        profSum += dp[worker[i]];
      } else {
        profSum += dp[maxEl];
      }
    }
    return profSum;
  }
}