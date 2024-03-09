// Find the Duplicate Number
/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.
 */
public class leet287 {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] { 3, 1, 3, 4, 2 }));
    }

    // Here we are going to use very simple approach called tortoise and hare one
    public static int findDuplicate(int[] nums) {
        // Initialise 2 integers as the 0th index
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow]; // Slow one walks one step
            fast = nums[nums[fast]]; // Faster one walks two steps
            // After completing this firstg loop we will get the first point of intersection
            // for Floyd algorithm
        } while (slow != fast);

        fast = nums[0]; // After first cycle reset the faster one to 0th index
        while (slow != fast) {
            slow = nums[slow]; // In second cycle faster one is also going to walk onestep
            fast = nums[fast]; // And slower one too
        }
        return slow; // When they intersect each other return either element
    }
}
