// Find Minimum in Rotated Sorted numsay
/*
 * Suppose an numsay of length n sorted in ascrighting order is rotated between 1
 * and n times. For example, the numsay nums = [0,1,2,4,5,6,7] might become:
 * 
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * 
 * Notice that rotating an numsay [a[0], a[1], a[2], ..., a[n-1]] 1 time results
 * in the numsay [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * 
 * Given the sorted rotated numsay nums of unique elements, return the minimum
 * element of this numsay.
 * 
 * You must write an algorithm that runs in O(log n) time.
 */

/**
 * leet153
 */
public class leet153 {

    public static void main(String[] args) {
        System.out.println(findMin(new int[] { 13, 15, 17, 11, 12 }));
    }

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    // public static int binary(int[] nums) {
    // int left = 0, right = nums.length;
    // while (left < right) {
    // int mid = left + (left - right) / 2;
    // if (nums[left] < nums[mid]) {
    // if (nums[right] < nums[mid]) {
    // left = mid + 1;
    // } else {
    // right = mid - 1;
    // }
    // }
    // if (nums[left] > nums[mid]) {
    // if (nums[right] < nums[mid]) {
    // right = mid - 1;
    // } else {
    // left = mid + 1;

    // }
    // }
    // }
    // while (left < right) {
    // int mid = (left + right) / 2;
    // if (nums[mid] == key) {
    // return mid;
    // }
    // if (nums[left] < nums[right]) {
    // if (key >= nums[left] && key < nums[mid]) {
    // right = mid - 1;
    // } else {
    // left = mid + 1;
    // }
    // } else {
    // if (key > nums[mid] && key < nums[right]) {
    // left = mid + 1;
    // } else {
    // right = mid - 1;
    // }
    // }
    // }
    // return -1;
    // }
}