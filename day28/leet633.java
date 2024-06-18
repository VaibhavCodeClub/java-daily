// Sum of Square Numbers
// Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

public class leet633 {
  public static void main(String[] args) {
    System.out.println(judgeSquareSum(2147483600));
  }

  public static boolean judgeSquareSum(int c) {
    int start = 0, end = (int) (Math.sqrt(c)); // Initialize start and end
    while (start <= end) { // Loop until start is greater than end
      // Calculate the sum of squares
      long sum = (long) start * start + (long) end * end;
      if (sum > c)
        end--; // Decrease end if sum is greater than c
      else if (sum < c)
        start++; // Increase start if sum is less than c
      else
        return true; // Return true if sum equals c
    }
    return false; // Return false if no such pair is found
  }
}
