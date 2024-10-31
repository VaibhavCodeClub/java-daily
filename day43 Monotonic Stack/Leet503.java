//Next Greater Element II
/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.*/
import java.util.*;

public class Leet503 {

  public static int[] nextGreaterElements(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int n = nums.length;
    int ans[] = new int[n];
    for (int i = n * 2 - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        ans[i % n] = -1;
      } else {
        ans[i % n] = stack.peek();
      }
      stack.push(nums[i % n]);
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
    System.out.println(Arrays.toString(nextGreaterElements(arr)));
    sc.close();
  }
}
