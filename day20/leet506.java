// Relative Ranks
/*
You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

    The 1st place athlete's rank is "Gold Medal".
    The 2nd place athlete's rank is "Silver Medal".
    The 3rd place athlete's rank is "Bronze Medal".
    For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").

Return an array answer of size n where answer[i] is the rank of the ith athlete.

*/

import java.util.Arrays;

public class leet506 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(findRelativeRanks(new int[] { 10, 3, 8, 9, 4 })));
  }

  public static String[] findRelativeRanks(int[] score) {
    int n = score.length;
    int max = 0;

    for (int x : score)
      max = x > max ? x : max;

    int score_idx[] = new int[max + 1];
    for (int i = 0; i < n; i++)
      score_idx[score[i]] = i + 1;

    String rank[] = new String[n];
    int c = 1;
    String medals[] = { "Gold Medal", "Silver Medal", "Bronze Medal" };

    for (int i = max; i >= 0; i--)
      if (score_idx[i] != 0) {
        int org_idx = score_idx[i] - 1;
        if (c < 4)
          rank[org_idx] = medals[c - 1];
        else
          rank[org_idx] = Integer.toString(c);
        c++;
      }
    return rank;
  }
}
