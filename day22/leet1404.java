// Number of Steps to Reduce a Number in Binary Representation to One
/*
Given the binary representation of an integer as a string s, return the number of steps to reduce it to 1 under the following rules:

    If the current number is even, you have to divide it by 2.

    If the current number is odd, you have to add 1 to it.

It is guaranteed that you can always reach one for all test cases.
 */

public class leet1404 {
  public static void main(String[] args) {
    System.out.println(new Solution().numSteps("11111100111010101100111001001011110110010"));
    System.out.println(new Solution2().numSteps("1111110011101010110011100100101110010100101110111010111110110010"));
  }
}

class Solution {
  public int numSteps(String s) {
    long a = Long.parseLong(s, 2);int steps = 0;
    while (a != 1) {
      if (a % 2 == 0) {
        a /= 2;
        steps++;
      } else {
        a += 1;
        steps++;
      }
    }
    return steps;
  }
}class Solution2 {
  public int numSteps(String s) {
      int steps = 0;
      
      StringBuilder sb = new StringBuilder(s);
      
      while (sb.length() > 1) {
          if (sb.charAt(sb.length() - 1) == '0') {
              sb.setLength(sb.length() - 1);
          } else {
              int i = sb.length() - 1;
              while (i >= 0 && sb.charAt(i) == '1') {
                  sb.setCharAt(i, '0');
                  i--;
              }
              if (i >= 0) {
                  sb.setCharAt(i, '1');
              } else {
                  sb.insert(0, '1');
              }
          }
          steps++;
      }
      
      return steps;
  }
}
