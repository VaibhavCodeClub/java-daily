// Patching Array
// Given a sorted integer array nums and an integer n, add/patch elements to the array such that any number in the range [1, n] inclusive can be formed by the sum of some elements in the array.

// Return the minimum number of patches required.

public class leet330 {
  public static void main(String[] args) {
    System.out.println(minPatches(new int[] { 1, 5, 10 }, 20));
  }

  public static int minPatches(int[] nums, int n) {
    int count = 0;
    long missing = 1;
    int i = 0;

    while (missing <= n) {
      if (i < nums.length && nums[i] <= missing) {
        missing += nums[i++];
      } else {
        missing += missing;
        count++;
      }
    }

    return count;
  }
}
