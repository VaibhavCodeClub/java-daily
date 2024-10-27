// Subarray Sum Equals K
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.

public class leet560 {
  public static void main(String[] args) {
    System.out.println(subarraySum(new int[] { 1, 1, 1 }, 2));
  }

  public static int subarraySum(int[] nums, int k) {
    // Exceeds time limit
    // int count = 0;
    // for (int i = 0; i < nums.length; i++) {
    //   for (int j = i; j < nums.length; j++) {
    //     int sum = 0;
    //     for (int index = i; index <= j; index++)
    //       sum += nums[index];
    //     if (sum == k)
    //       count++;
    //   }
    // }
    // return count;
  }
}
