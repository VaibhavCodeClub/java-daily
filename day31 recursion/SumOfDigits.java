public class SumOfDigits {

  public static void main(String args[]) {
    System.out.print(sumOfDigits(12345));
  }

  private static int sumOfDigits(int n) {
    if (n < 10) return n;
    return (sumOfDigits(n / 10) + (n % 10));
  }
}
