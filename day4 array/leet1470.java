// Shuffle the Array

// Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

// Return the array in the form [x1,y1,x2,y2,...,xn,yn].

import java.util.Arrays;

public class leet1470 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 }, 4)));
    }

    public static int[] shuffle(int[] nums, int n) {
        // int k = 0;
        // for (int i = 0, j = n; i < n+1 && j < nums.length ;) {
        // if (k % 2 == 0) {
        // ret[k] = nums[i];
        // i++;
        // k++;
        // } else {
        // ret[k] = nums[j];
        // j++;
        // k++;
        // }
        // }

        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[n + i];
        }
        return result;
    }
}
