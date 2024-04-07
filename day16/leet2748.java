// Number of Beautiful Pairs
/**
 * You are given a 0-indexed integer array nums. A pair of indices i, j where 0
 * <= i < j < nums.length is called beautiful if the first digit of nums[i] and
 * the last digit of nums[j] are coprime.
 * 
 * Return the total number of beautiful pairs in nums.
 * 
 * Two integers x and y are coprime if there is no integer greater than 1 that
 * divides both of them. In other words, x and y are coprime if gcd(x, y) == 1,
 * where gcd(x, y) is the greatest common divisor of x and y.
 */

public class leet2748 {
  public static void main(String[] args) {
    System.out.println(countBeautifulPairs(new int[] { 31,25,72,79,74 }));
  }

  public static int countBeautifulPairs(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int left = getFirst(nums[i]);
        int right = getLast(nums[j]);
        if (getGCD(left, right) == 1)
          count++;
      }
    }
    return count;
  }

  private static int getFirst(int n) {
    while (n >= 10) {
      n /= 10;
    }
    return n;
  }

  private static int getLast(int n) {
    return n % 10;
  }

  private static int getGCD(int n, int p) {
    while (p != 0) {
      int temp = p;
      p = n % p;
      n = temp;
    }
    return n;
  }

}
