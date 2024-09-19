// Make Two Arrays Equal by Reversing Subarrays
// You are given two integer arrays of equal length target and arr. In one step, you can select any non-empty subarray of arr and reverse it. You are allowed to make any number of steps.

// Return true if you can make arr equal to target or false otherwise.
import java.util.Arrays;

class leet1460 {
  public static void main(String args[]) {
    System.out.print(canBeEqual(new int[] { 7 }, new int[] { 7 }));
  }

  public static boolean canBeEqual(int[] target, int[] arr) {
    Arrays.sort(target);
    Arrays.sort(arr);
    int b = Arrays.compare(target, arr);
    return b == 0;
  }
}
