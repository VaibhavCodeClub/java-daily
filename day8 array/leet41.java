// First Missing Positive
// Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

// You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

public class leet41 {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] { 7, 8, 9, 11, 12 }));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length; // Grab the length of array
        boolean contain = false; // Bllo for checking if 1 i spresent or not
        for (int i = 0; i < n; i++)
            // Loop to heck if 1 is present or not
            if (nums[i] == 1)
                // if 1 is present then make that bool true
                contain = true;
        if (!contain)
            // If 1 is not present return 1
            return 1;

        for (int i = 0; i < n; i++) {
            // If 1 is present then
            if (nums[i] <= 0 || nums[i] > n) {
                // Make all 0's and negative numbers == 1 as there is no value to them
                // As well the numbers larger than the length of array as if that number is
                // present its obvious that we have missing smaller value which is smaller than
                // the length of that array
                nums[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            // After changing array now make the index of i's negative such that we kan
            // acknowledge that that number is present in array
            int indes = Math.abs(nums[i]) - 1; // After making number negative abs is used to handle that negative
                                               // values and -1 for index starts fron 0 not position
            if (nums[indes] > 0) {
                // Negate the value at nums[i]
                nums[indes] = -nums[indes];
            }
        }
        for (int i = 0; i < n; i++) {
            // iterate again and check if there is any positive number
            if (nums[i] > 0) {
                // if found return the that index+1 as we are iterating from i=0
                return i + 1;
            }
        }
        // else return n+1 because all numbers are present
        return n + 1;
    }
}