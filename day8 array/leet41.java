// First Missing Positive
// Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

// You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

public class leet41 {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
    }

    public static int firstMissingPositive(int[] nums) {
        // Arrays.sort(nums);
        // int i = 1;
        // for (; i < n - 1;) {
        // if (nums[i] <= 0) {
        // i++;
        // continue;
        // } else {
        // if (nums[i] != i)
        // return i;
        // i++;
        // }
        // }
        // return i + 1;
        int n = nums.length;
        boolean contain = false;
        for (int i = 0; i < n; i++)
            if (nums[i] == 1)
                contain = true;
        if (!contain)
            return 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int indes = Math.abs(nums[i]) - 1;
            if (nums[indes] > 0) {
                nums[indes] = -nums[indes];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}