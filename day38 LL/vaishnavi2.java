import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class vaishnavi2 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    String[] input = br.readLine().split(" ");
    int[] elements = new int[N];
    for (int i = 0; i < N; i++) {
      elements[i] = Integer.parseInt(input[i]);
    }

    System.out.println(minByproduct(elements, N));
  }

  public static int minByproduct(int[] elements, int N) {
    int[][] dp = new int[N][N];
    int[][] sum = new int[N][N];

    for (int i = 0; i < N; i++) {
      sum[i][i] = elements[i];
      for (int j = i + 1; j < N; j++) {
        sum[i][j] = (sum[i][j - 1] + elements[j]) % 100;
      }
    }

    for (int len = 2; len <= N; len++) {
      for (int i = 0; i <= N - len; i++) {
        int j = i + len - 1;
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
          int cost = dp[i][k] + dp[k + 1][j] + sum[i][k] * sum[k + 1][j];
          dp[i][j] = Math.min(dp[i][j], cost);
        }
      }
    }

    return dp[0][N - 1];
  }
}
