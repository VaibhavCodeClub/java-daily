// Next Greater Element I
/*
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
*/
import java.util.*;

public class Leet496 {

  public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Stack<Integer> stack = new Stack<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = nums2.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() < nums2[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        stack.push(nums2[i]);
        map.put(nums2[i], -1);
      } else if (stack.peek() > nums2[i]) {
        map.put(nums2[i], stack.peek());
        stack.push(nums2[i]);
      } else {}
    }
    // System.out.println(stack);
    // System.out.println(map);

    for (int i = 0; i < nums1.length; i++) {
      nums1[i] = map.get(nums1[i]);
    }
    return nums1;
  }

  public static ArrayList<Integer> nextGreaterElement2(int[] nums1) {
    Stack<Integer> stack = new Stack<>();
    ArrayList<Integer> arr = new ArrayList<>();
    for (int i = nums1.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= nums1[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        arr.add(0, -1);
      } else {
        arr.add(0, stack.peek());
      }
      stack.push(nums1[i]);
    }
    return arr;
  }

  public static int[] nextGreaterElement3(int[] nums1, int n) {
    Stack<Integer> stack = new Stack<>();
    int[] arr = new int[n];
    n--;
    for (int i = nums1.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= nums1[i]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        arr[n--] = -1;
      } else {
        arr[n--] = stack.peek();
      }
      stack.push(nums1[i]);
    }
    return arr;
  }

  public static void main(String[] args) {
    System.out.println(
      Arrays.toString(
        nextGreaterElement(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 })
      )
    );
    System.out.println(nextGreaterElement2(new int[] { 6, 8, 0, 1, 3 }));
    System.out.println(
      Arrays.toString(nextGreaterElement3(new int[] { 1, 5, 3, 4, 2 }, 5))
    );
  }
}
