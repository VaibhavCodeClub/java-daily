// Count Number of Nice Subarrays

// Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

// Return the number of nice sub-arrays.
import java.util.HashMap;
import java.util.Map;

public class leet1248 {
  public static void main(String[] args) {
    System.out.println(numberOfSubarrays(new int[] { 1, 1, 2, 1, 1 }, 3));
    System.out.println(numberOfSubarrays0(new int[] { 1, 1, 2, 1, 1 }, 3));
  }

  public static int numberOfSubarrays(int[] nums, int k) {
    int count = 0, oddCount = 0;
    Map<Integer, Integer> prefixCount = new HashMap<>();
    prefixCount.put(0, 1);
    for (int i : nums) {
      if (i % 2 == 1)
        oddCount++;
      if (prefixCount.containsKey(oddCount - k))
        count += prefixCount.get(oddCount - k);
      prefixCount.put(oddCount, prefixCount.getOrDefault(oddCount, 0) + 1);
    }
    return count;
  }

  public static int numberOfSubarrays0(int[] nums, int k) {
    int n = nums.length;
    int[] map = new int[50001];
    int sum = 0;
    map[0] = 1;
    int count = 0;
    int goal = k;
    for (int i = 0; i < n; i++) {
      sum += nums[i] % 2;
      if (sum >= goal)
        count += map[sum - goal];
      map[sum]++;
    }
    return count;
  }
}
