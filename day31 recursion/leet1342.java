// Number of Steps to Reduce a Number to Zero
// Given an integer num, return the number of steps to reduce it to zero.

// In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.

public class leet1342 {

  public static void main(String args[]) {
    System.out.print(numberOfSteps(41));
  }

  public static int numberOfSteps(int num) {
    return (helper(num, 0));
  }

  private static int helper(int num, int steps) {
    if (num == 0) return steps;
    if (num % 2 == 0) num /= 2;
    else num -= 1;
    return helper(num, ++steps);
  }
}
