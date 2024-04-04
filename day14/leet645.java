// Set Mismatch
// You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

// You are given an integer array nums representing the data status of this set after the error.

// Find the number that occurs twice and the number that is missing and return them in the form of an array.

import java.util.Arrays;

public class leet645 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[] { 1, 1 })));
    }

    public static int[] findErrorNums(int[] nums) {
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
                return new int[] { nums[i], i + 1 };
        return null;
    }
}
