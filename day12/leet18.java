// 4Sum
/*  Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

    0 <= a, b, c, d < n
    a, b, c, and d are distinct.
    nums[a] + nums[b] + nums[c] + nums[d] == target

You may return the answer in any order.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet18 {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[] { 1000000000, 1000000000, 1000000000, 1000000000 }, -294967296));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1, right = nums.length - 1;

                while (left < right) {
                    long currSum =(long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (currSum == target) {
                        List<Integer> currList = new ArrayList<>();
                        currList.add(nums[i]);
                        currList.add(nums[j]);
                        currList.add(nums[left]);
                        currList.add(nums[right]);
                        if (!ret.contains(currList)) {
                            ret.add(currList);
                        }
                    }
                    if (currSum < target)
                        left++;
                    else
                        right--;
                }
            }
        }
        return ret;
    }
}
