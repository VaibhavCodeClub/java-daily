//  Merge Sorted Array
/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
*/

import java.util.Arrays;

public class leet88 {
    public static void main(String[] args) {
        merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // for (int i = m; i < nums1.length && n > 0; i++) {
        // nums1[i] = nums2[n - 1];
        // n--;
        // }
        // Arrays.sort(nums1);

        int i = m - 1; // The position of the last element of the nums1 array
        int j = n - 1; // The position of the last element from the nums2
        int k = m + n - 1; // the position of the last element in nums1 including 0's

        while (j >= 0)
            // Iterate until we reach the end of nums2 from right to left
            if (i >= 0 && nums1[i] > nums2[j])
                // if we are not at the last element of the nums1 and current element from nums1
                // is greater than current element from nums2
                // Then place the current nums1 element at k'th position and decrement both the
                // k and i
                nums1[k--] = nums1[i--];
            else
                // else place the current nums2 element at k'th position and decrement both the
                // j and k
                nums1[k--] = nums2[j--];

        System.out.println(Arrays.toString(nums1));
    }
}
