// Product of Array Except Self
/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
 */

import java.util.Arrays;

public class leet238 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] { -1, 1, 0, -3, 3 })));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];

        int left = 1;
        // Making of prefix array here
        for (int i = 0; i < ret.length; i++) {
            // run the for loop for entire array
            ret[i] = left;
            // current index value of the returning array is equal to left
            // so at index 1 it will be just 1
            left *= nums[i];
            // multiply left part by current index value to store it in next index of prefix
            // array
        }
        int right = 1; // To set the rightmost element as 1 declare right = 1
        for (int i = nums.length - 1; i >= 0; i--) {
            // iterate through whole array in reverse order
            // multiply the current index of the returning array by right
            ret[i] *= right;
            // make right * current index to use it in next iteration
            right *= nums[i];
        }
        // this approach is too much time consuming
        // for (int i = 0; i < ret.length; i++) {
        // int sum = 1;
        // for (int j = 0; j < ret.length; j++) {
        // if (i == j) {
        // continue;
        // }
        // sum *= nums[j];
        // }
        // ret[i] = sum;
        // }
        return ret;
    }
}
