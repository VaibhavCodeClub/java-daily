// Happy numbers
/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

    Starting with any positive integer, replace the number by the sum of the squares of its digits.
    Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy.

Return true if n is a happy number, and false if not.
 */

import java.util.HashSet;
import java.util.Set;

public class leet202 {
  public static void main(String[] args) {
    System.out.println(isHappy(2));
    System.out.println(isHappy2(91));
  }

  public static boolean isHappy(int n) {
    // Set to keep track of all the outputs
    Set<Integer> intSet = new HashSet<>();

    // Infinite loop
    while (true) {
      // Initialise sum
      int sum = 0;

      // Calculate the sum of the square of each digits in n
      while (n != 0) {
        sum += (n % 10) * (n % 10);
        n /= 10;
      }

      // If the sum is 1 then the number is happy one return true
      if (sum == 1)
        return true;

      // else set n as current sum
      n = sum;

      // If that value is present in the HashSet then we are looping so return false
      if (intSet.contains(n))
        return false;

      // Else simply add that sum value in HashSet
      intSet.add(n);
    }
  }

  public static boolean isHappy2(int n) {
    for (int i = 0; i < 7; i++) {
      n = calc(n);
      if (n == 1) {
        return true;
      }
    }
    return false;
  }

  public static int calc(int n) {
    int sum = 0;
    int num = 0;
    while (n > 0) {
      num = n % 10;
      sum += num * num;
      n = n / 10;
    }
    return sum;
  }

}
