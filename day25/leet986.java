// Interval List Intersections
/*
You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.
A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet986 {
  public static void main(String[] args) {
    int[][] soln = intervalIntersection(new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } },
        new int[][] { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } });
    int[][] soln00 = intervalIntersection00(new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } },
        new int[][] { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } });

    for (int[] is : soln) {
      System.out.print(Arrays.toString(is));
    }
    System.out.println();
    for (int[] is : soln00) {
      System.out.print(Arrays.toString(is));
    }
  }

  public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    int firstLength = firstList.length, secondLength = secondList.length;
    int[][] resultantList = new int[firstLength + secondLength][2];
    int i = 0, j = 0, k = 0;

    while (i < firstLength && j < secondLength) {
      if (firstList[i][0] <= secondList[j][1] && secondList[j][0] <= firstList[i][1]) {
        resultantList[k++] = new int[] { Math.max(firstList[i][0], secondList[j][0]),
            Math.min(firstList[i][1], secondList[j][1]) };
      }
      if (firstList[i][1] < secondList[j][1]) {
        i++;
      } else {
        j++;
      }
    }
    return Arrays.copyOf(resultantList, k);
  }

  // Below is better approach in both the TC and SC
  public static int[][] intervalIntersection00(int[][] firstList, int[][] secondList) {
    List<int[]> ans = new ArrayList<>();
    int i = 0, j = 0;

    while (i < firstList.length && j < secondList.length) {
      int lo = Math.max(firstList[i][0], secondList[j][0]);
      int hi = Math.min(firstList[i][1], secondList[j][1]);
      if (lo <= hi) {
        ans.add(new int[] { lo, hi });
      }
      if (firstList[i][1] < secondList[j][1]) {
        i++;
      } else {
        j++;
      }
    }
    return ans.toArray(new int[ans.size()][]);
  }
}
