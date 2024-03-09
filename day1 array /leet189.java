// Rotate array
// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.


// This approach takes more time but less memmory 
// First reverse whole array
// Second reverse array from 0 to k-1
// Thirdly reverse array k to end i.e. length - 1
import java.util.Arrays;

public class leet189 {
    public static void main(String[] args) {
        rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}