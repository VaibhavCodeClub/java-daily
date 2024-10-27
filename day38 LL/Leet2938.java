/*
 * There are n balls on a table, each ball has a color black or white.

You are given a 0-indexed binary string s of length n, where 1 and 0 represent black and white balls, respectively.

In each step, you can choose two adjacent balls and swap them.

Return the minimum number of steps to group all the black balls to the right and all the white balls to the left.


 */
public class Leet2938 {
  public static void main(String[] args) {
    System.out.print(minimumSteps("01110000"));
  }

  public static long minimumSteps(String s) {
    long black = 0;
    long result = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1')
        black++;
      else
        result += black;
    }
    return result;
  }
}
