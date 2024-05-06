// Maximum Product of Two Elements in an Array
// Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1). 

import java.util.Arrays;

public class leet1464 {
  public static void main(String[] args) {
    System.out.println(maxProduct(new int[] { 1, 5, 4, 5 }));
    System.out.println(maxProduct0(new int[] { 1, 5, 4, 5 }));
  }

  public static int maxProduct(int[] nums) {
    int maxProduct = 0;
    int left = 0;
    int n = nums.length - 1, right = n;
    while (left != n) {
      if (left == right) {
        left++;
        right = n;
        continue;
      }
      int curProduct = (nums[left] - 1) * (nums[right] - 1);
      right--;
      maxProduct = maxProduct > curProduct ? maxProduct : curProduct;
    }
    return maxProduct;
  }

  public static int maxProduct0(int[] nums) {
    int n = nums.length - 1;
    Arrays.sort(nums);
    return (nums[n] - 1) * (nums[n - 1] - 1);
  }
}
