// Search in Rotated Sorted Array

/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
 */
public class leet33 {

    public static void main(String[] args) {
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
    }

    public static int search(int[] nums, int target) {

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                // If the target element is ount return the index
                return mid;
            }
            if (nums[start] <= nums[mid]) {
                // if the left part of the mid is sorted
                if (target >= nums[start] && target <= nums[mid]) {
                    // and ouit target element lies between that sorted part then just move end to
                    // mid-1
                    // meaning eliminate the right half part of the array as our element is not
                    // there
                    end = mid - 1;
                } else {
                    // else search in the right half of the array
                    start = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[end]) {
                    // and if right half of array is sorted then check if our target element lies
                    // there or not
                    // if lies then continue searching in right part
                    start = mid + 1;
                } else {
                    // else continue searching on left half
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

}