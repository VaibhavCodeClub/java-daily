// Defuse the Bomb
/*
You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length of n and a key k.

To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.

    If k > 0, replace the ith number with the sum of the next k numbers.
    If k < 0, replace the ith number with the sum of the previous k numbers.
    If k == 0, replace the ith number with 0.

As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].

Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!
*/

import java.util.Arrays;

public class leet1652 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(decrypt(new int[] { 2, 4, 9, 3 }, -2)));
  }

  private static int getSum(int[] code, int start, int end) {
    // This function calculates the sum between the provided indexes of the Array
    int sum = 0; // Initialise sum as 0
    int n = code.length;
    for (; start <= end; start++) {
      // Loop until the start is less than equal to end and
      // add the value at each index in sum
      // mod the index by n to handle the index going beyond length of the array as
      // wew are using circular logic same for negatives too
      sum += code[(start + n) % n];
    }
    return sum;
  }

  public static int[] decrypt(int[] code, int k) {
    // Create new array to store the decrypted code
    int[] decrypt = new int[code.length];

    if (k == 0) {
      // If the k is equal to 0 pass
      // as defult value in the arrays are 0
    } else if (k > 0) {
      // If the k is positive then pass the i+1 as start index and i+k as end index to
      // calculate the sum
      for (int i = 0; i < code.length; i++) {
        decrypt[i] = getSum(code, i + 1, i + k);
      }
    } else {
      // If the k is negative then pass the i+k (as k is negative k gets negated) as
      // start index and i-1 as end index to
      // calculate the sum
      for (int i = 0; i < code.length; i++) {
        decrypt[i] = getSum(code, i + k, i - 1);
      }
    }
    return decrypt;
  }
}
