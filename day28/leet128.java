// Longest Consecutive Sequence
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

import java.util.HashSet;

public class leet128 {
  public static void main(String[] args) {
    System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
    System.out.println(longestConsecutive0(new int[] { 100, 4, 200, 1, 3, 2 }));
  }

  public static int longestConsecutive(int[] nums) {
    int n = nums.length;
    if (n == 0)
      return 0;
    int longest = 1;

    HashSet<Integer> intSet = new HashSet<>();

    for (int integer : nums)
      intSet.add(integer);

    for (Integer integer : intSet)
      if (!intSet.contains(integer - 1)) {
        int cnt = 1;
        int x = integer;
        while (intSet.contains(x + 1)) {
          x++;
          cnt++;
        }
        longest = Math.max(cnt, longest);
      }
    return longest;
  }

  // This is th ebetter approach which gives 5ms compared to above 37ms
  public static int longestConsecutive0(int[] nums) {
    if (nums.length <= 1)
      return nums.length;
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= -999999999)
        nums[i] = -99;
      if (nums[i] < min)
        min = nums[i];
      if (nums[i] >= 999999999)
        nums[i] = 99;
      if (nums[i] > max)
        max = nums[i];
    }
    int[] freqs = new int[max - min + 1];
    for (int val : nums)
      freqs[val - min] += 1;
    // keep track of consecutive non-zero entries in the freqs array
    int current_max_length = 0, length = 0;
    for (int value : freqs)
      if (value != 0)
        current_max_length += 1;
      else {
        if (current_max_length > length) {
          length = current_max_length;
        }
        current_max_length = 0;
      }
    System.gc();
    return Math.max(length, current_max_length);
  }
}
