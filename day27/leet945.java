// Minimum Increment to Make Array Unique

// You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.

// Return the minimum number of moves to make every value in nums unique.

// The test cases are generated so that the answer fits in a 32-bit integer.

import java.util.Arrays;

public class leet945 {
  public static void main(String[] args) {
    System.out.println(minIncrementForUnique(new int[] { 3, 2, 1, 2, 1, 7 }));
  }

  public static int minIncrementForUnique(int[] nums) {
    if(nums.length==1) return 0;
    Arrays.sort(nums);
    int ans = 0;
    for(int i = 1; i< nums.length;i++){
        if(nums[i]<=nums[i-1]){
            int temp = (nums[i-1]+1)-nums[i];
            nums[i]+=temp;
            ans+=temp;
        }
    }
    return ans;
  }
}
