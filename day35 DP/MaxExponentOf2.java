public class MaxExponentOf2 {

  // Function to compute the exponent of 2 in the factorization of a number
  private static int countExponentOf2(int n) {
    int count = 0;
    while (n % 2 == 0) {
      count++;
      n /= 2;
    }
    return count;
  }

  // Function to find the number with the maximum exponent of 2 in the range [a, b]
  public static int intMaxExponents(int a, int b) {
    int maxExponent = -1;
    int numberWithMaxExponent = a;

    for (int i = a; i <= b; i++) {
      int currentExponent = countExponentOf2(i);
      if (currentExponent > maxExponent) {
        maxExponent = currentExponent;
        numberWithMaxExponent = i;
      }
    }

    return numberWithMaxExponent;
  }

  public static void main(String[] args) {
    int a = 10;
    int b = 200;

    int result = intMaxExponents(a, b);
    System.out.println(
      "The number with the maximum exponent of 2 in the range [" +
      a +
      ", " +
      b +
      "] is: " +
      result
    );
  }
}
