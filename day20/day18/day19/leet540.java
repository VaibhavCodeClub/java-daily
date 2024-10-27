// Single Element in a Sorted Array
/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
Return the single element that appears only once.
Your solution must run in O(log n) time and O(1) space.
*/

public class leet540 {
  public static void main(String[] args) {
    System.out.println(singleNonDuplicate(new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 8, 8 }));
  }

  public static int singleNonDuplicate(int[] nums) {
    int n = nums.length - 1;
    if (nums.length == 1)
      return nums[0];
    if (nums[0] != nums[1])
      return nums[0];
    if (nums[n] != nums[n - 1])
      return nums[n];

    int left = 0, right = n;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1])
        return nums[mid];

      if (mid % 2 == 0) {
        if (nums[mid] != nums[mid + 1])
          right = mid - 1;
        else
          left = mid + 1;
      }

      else {
        if (nums[mid] != nums[mid - 1])
          right = mid - 1;
        else
          left = mid + 1;
      }
    }
    return -1;

    // Less complex approach is below

    // int left = 0, right = nums.length - 1;
    // while (left < right) {
    // int mid = left + (right - left) / 2;
    // if (mid % 2 == 1) {
    // mid--; // Ensure mid is always even
    // }
    // if (nums[mid] != nums[mid + 1]) {
    // right = mid;
    // } else {
    // left = mid + 2;
    // }
    // }
    // return nums[left];
  }
}
