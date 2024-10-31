//Next Greater Element II
/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.*/
import java.util.*;

public class PrevSmaller {

  public static ArrayList<Integer> prevSmaller(ArrayList<Integer> nums) {
    Stack<Integer> stack = new Stack<>();
    int n = nums.size();
    ArrayList<Integer> result = new ArrayList<>(n);

    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && stack.peek() >= nums.get(i)) {
        stack.pop();
      }
      result.add(stack.isEmpty() ? -1 : stack.peek());
      stack.push(nums.get(i));
    }

    return result;
  }

  public static ArrayList<Integer> prevSmaller2(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int n = nums.length;
    ArrayList<Integer> result = new ArrayList<>(n);

    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && stack.peek() >= nums[i]) {
        stack.pop();
      }
      result.add(stack.isEmpty() ? -1 : stack.peek());
      stack.push(nums[i]);
    }

    return result;
  }

  public static void main(String[] args) {
    ArrayList<Integer> nums = new ArrayList<>(
      Arrays.asList(39, 27, 11, 4, 24, 32, 32, 1)
    );
    ArrayList<Integer> previousSmaller = prevSmaller(nums);
    System.out.println(previousSmaller);
  }
}
