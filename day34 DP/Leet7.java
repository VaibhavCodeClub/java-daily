// Reverse Integer

// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
public class Leet7 {
  public static void main(String[] args) {
    System.out.println(reverse(-123));
  }
  public static int reverse(int x) {
    long rev = 0, r = 0;

    if (x < 0) {
      x *= -1;
      r++;
    }
    while (x > 0) {
      int rem = x % 10;
      rev = rem + (rev * 10);
      x /= 10;
    }
    if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
      return 0;
    }
    if (r != 0) {
      rev *= -1;
    }
    return (int) rev;
  }
}
