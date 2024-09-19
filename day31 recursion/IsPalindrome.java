public class IsPalindrome {

  private static int reverse(int i) {
    int digit = (int) (Math.log10(i)) + 1;
    return helper(i, digit);
  }

  private static int helper(int i, int digit) {
    if (i < 10) return i;
    int rem = i % 10;
    return rem * (int) (Math.pow(10, digit - 1)) + helper(i / 10, digit - 1);
  }

  private static boolean isPalindrome(int i) {
    return (i == reverse(i));
  }

  public static void main(String args[]) {
    System.out.print(isPalindrome(12121));
  }
}
