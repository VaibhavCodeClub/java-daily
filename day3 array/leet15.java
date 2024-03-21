// 3sum
/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet15 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        // Create an empty list of list of integers as it is the return type of the
        // function
        List<List<Integer>> ans = new ArrayList<>();
        // loop the sorted array
        for (int i = 0; i < nums.length; i++) {
            // if the i is not on first place and the next element we proceeded is similar
            // to the previous one then just continus as we dont want the duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // Declare j as i+1
            int j = i + 1;
            // Declare k and end of array
            int k = nums.length - 1;

            // loop till the j is less than k
            while (j < k) {
                // calculate the sum of that three elements
                int sum = nums[i] + nums[j] + nums[k];
                // if the sum is newgative
                if (sum < 0) {
                    // then we just have to increase the value of j
                    j++;
                    // else if the sum is positive then decrease the value of k
                } else if (sum > 0) {
                    k--;
                    // else our sum is 0 we got our triplet
                } else {
                    // Create the temprory arraylist to store that triplet
                    List<Integer> temp = new ArrayList<>();
                    // Add all the three value to the list
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    // add that temprory list to the final list
                    ans.add(temp);

                    // after doing so we have to change the values of both j and k
                    j++;
                    k--;
                    // If the value of j is less than j and similar to previous value of itself just
                    // increase the j by 1
                    while (j < k && nums[j] == nums[j - 1])
                        j++;

                    // If the value of j is less than k and similar to previous value of itself just
                    // decreasease the j by 1
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }
        }
        // return the final list
        return ans;
    }
}
