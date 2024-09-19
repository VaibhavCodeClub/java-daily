public class ProductOfDigits {

  public static void main(String args[]) {
    System.out.print(prodOfDigits(55));
  }

  private static int prodOfDigits(int n) {
    if (n < 10) return n;
    return (prodOfDigits(n / 10) * (n % 10));
  }
}
