// Jump Game
// You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

// Return true if you can reach the last index, or false otherwise.

public class leet55 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
    }

    public static boolean canJump(int[] nums) {
        int ans = nums.length - 1; // Initialise the ans at the end of an array
        for (int i = nums.length - 1; i >= 0; i--) // Iterate through the array inversly
            if (i + nums[i] >= ans) // see if we can reach the destination from the current position or not
                ans = i; // if yes nove our destination to current position

        return ans == 0; // return the ans if it is first position of array or not
    }
}

// Logic iterate the array from the last element we have to apply a simple logic
// here just move a cursor to the left one by one and check if from that
// position we can reach the destination or not if we can then move the
// destination at that point and continue doing same until we reach the index 0
// if we cannot reach the 0 th index then return false else true
