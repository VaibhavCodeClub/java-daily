// Find the Duplicate Number
// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

// There is only one repeated number in nums, return this repeated number.

// You must solve the problem without modifying the array nums and uses only constant extra space.

// Using cyclic sort
// Amazon question

public class leet287 {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
    }

    public static int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length;) {
            if (nums[i] == i + 1 || nums[i] == nums[nums[i] - 1]) {
                i++;
                continue;
            }
            int temp = nums[nums[i] - 1];
            nums[nums[i] - 1] = nums[i];
            nums[i] = temp;
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return nums[i];
        return -1;
    }
}