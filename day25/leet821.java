// Shortest Distance to a Character
// Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in s.

// The distance between two indices i and j is abs(i - j), where abs is the absolute value function.

import java.util.Arrays;

public class leet821 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(shortestToChar("aaab", 'b')));
  }

  // I wasn't sure that this solution will be faster than that of 99% as well in
  // SC it defeats 77% too

  private static int getNearestCount(int i, int[] occurances) {
    int closest = Integer.MAX_VALUE;
    for (int iterable : occurances) {
      closest = Math.min(Math.abs(i - iterable), closest);
    }
    return closest;
  }

  public static int[] shortestToChar(String s, char c) {
    int occurancesCount = 0, len = s.length();
    int[] occurances = new int[len];
    int[] resultArray = new int[len];
    for (int i = 0; i < len; i++) {
      if (s.charAt(i) == c) {
        occurances[occurancesCount++] = i;
      }
    }
    occurances = Arrays.copyOf(occurances, occurancesCount);
    for (int i = 0; i < len; i++) {
      resultArray[i] = getNearestCount(i, occurances);
    }
    return resultArray;
  }
}
