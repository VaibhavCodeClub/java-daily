public class DifferenceOfSum {

  public static int differenceOfSum(int m, int n) {
    // Calculate the sum of all integers from 1 to n
    int sumAll = (n * (n + 1)) / 2;

    // Calculate the number of multiples of m up to n
    int k = n / m;

    // Calculate the sum of all multiples of m up to n
    int sumDivisible = (m * k * (k + 1)) / 2;

    // Calculate the difference
    int difference = 2 * sumDivisible - sumAll;

    return difference;
  }

  public static void main(String[] args) {
    // Example usage
    int m = 6;
    int n = 30;
    System.out.println(differenceOfSum(m, n)); // Output should be 285
  }
}
