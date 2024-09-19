// Missing Number

// Using cyclic sorting algorithm and O(1) space complexity
// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
// Used in amazon

public class leet268 {

  public static void main(String[] args) {
    System.out.println(missingNumber(new int[] { 0, 2 }));
  }

  public static int missingNumber(int[] nums) {
    for (int i = 0; i < nums.length;) {
      if (nums[i] == i || nums[i] == nums.length) {
        // If number is at correct position or is equal to the length of array ignore it
        i++;
        continue;
      }
      // Store all the elements at it's correct position using swapping
      int temp = nums[nums[i]];
      nums[nums[i]] = nums[i];
      nums[i] = temp;
    }
    for (
      int i = 0;
      i < nums.length;
      i++
    ) // Iterate through the entire array again and when index mismatches the value
    // return the value
    if (nums[i] != i) return i;
    return nums.length;
  }
}
