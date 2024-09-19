// Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn?

// You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. Your task is to calculate the maximum number of merit points that Ninja can earn.
// For Example

// If the given ‘POINTS’ array is [[1,2,5], [3 ,1 ,1] ,[3,3,3] ],the answer will be 11 as 5 + 3 + 3.

import java.util.Arrays;

public class NinjaTraining {
  public static void main(String[] args) {
    System.out.println(ninjaTraining(3, new int[][] { { 10,40,70 }, { 20,50,80 }, { 30,60,90 } }));
    System.out.println(ninjaTraining2(3, new int[][] { { 10,40,70 }, { 20,50,80 }, { 30,60,90 } }));
  }

  private static int function(int day, int last, int[][] points, int[][] dp) {
    if (day == 0) {
      int max = 0;
      for (int task = 0; task < 3; task++) {
        if (task != last)
          max = Math.max(max, points[0][task]);
      }return max;
    }
    if (dp[day][last] != -1)
      return dp[day][last];
    int max = 0;
    for (int i = 0; i < 3; i++) {
      if (i != last) {
        int curPoints = points[day][i] + function(day - 1, i, points, dp);
        max = Math.max(max, curPoints);
      }

    }
    return dp[day][last] = max;
  }

  public static int ninjaTraining(int n, int points[][]) {
    int[][] dp = new int[n][4];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }
    return function(n-1, 3, points, dp);
  } 

  static int ninjaTraining2(int n, int[][] points) {
    // Initialize a 2D array 'dp' to store the maximum points
    int[][] dp = new int[n][4];
    
    // Initialize the first day's maximum points based on the available choices
    dp[0][0] = Math.max(points[0][1], points[0][2]);
    dp[0][1] = Math.max(points[0][0], points[0][2]);
    dp[0][2] = Math.max(points[0][0], points[0][1]);
    dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

    // Iterate through each day and each activity
    for (int day = 1; day < n; day++) {
        for (int last = 0; last < 4; last++) {
            dp[day][last] = 0; // Initialize the maximum points for the current day and last activity
            // Consider each possible task for the current day
            for (int task = 0; task <= 2; task++) {
                if (task != last) { // Ensure that the current task is different from the last
                    // Calculate the points for the current activity and add it to the maximum points from the previous day
                    int activity = points[day][task] + dp[day - 1][task];
                    // Update the maximum points for the current day and last activity
                    dp[day][last] = Math.max(dp[day][last], activity);
                }
            }
        }
    }

    // Return the maximum points achievable after all days (last activity is 3)
    return dp[n - 1][3];
}
}
