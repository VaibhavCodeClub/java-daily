public class Reverse {

  public static void main(String args[]) {
    System.out.print(reverse(1254));
    // System.out.print(sum);
  }

  static int sum = 0;

  private static int reverse(int i) {
    if (i == 0) return 0;
    int rem = i % 10;
    sum = sum * 10 + rem;
    reverse(i / 10);
    return sum;
  }
}
