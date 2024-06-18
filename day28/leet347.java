// Top K Frequent Elements
// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
// Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet347 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(topKFrequent(new int[] { 1, 2, 3, 3 }, 2)));
    System.out.println(Arrays.toString(topKFrequent(new int[] { 1, 2, 3, 3 }, 2)));
  }

  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int num : nums) {
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }

    List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(countMap.entrySet());
    entryList.sort((a, b) -> b.getValue() - a.getValue()); // Sort in descending order of frequency

    int[] ans = new int[k];
    int index = 0;
    for (Map.Entry<Integer, Integer> entry : entryList) {
      if (index >= k) {
        break;
      }
      ans[index++] = entry.getKey();
    }
    return ans;
  }

  public static int[] topKFrequent0(int[] nums, int k) {
    // Create an array of Lists to store numbers based on their frequency
    List<Integer>[] bucket = new List[nums.length + 1];

    // HashMap to count occurrences of each number in nums array
    HashMap<Integer, Integer> countHashMap = new HashMap<>();

    // Count occurrences of each number in nums
    for (int i : nums) {
      countHashMap.put(i, countHashMap.getOrDefault(i, 0) + 1);
    }

    // Place numbers into the bucket based on their frequency
    for (int get : countHashMap.keySet()) {
      int freq = countHashMap.get(get);
      if (bucket[freq] == null) {
        bucket[freq] = new ArrayList<>();
      }
      bucket[freq].add(get);
    }

    // Prepare the final answer array of size k
    int[] ans = new int[k];
    int count = 0;

    // Traverse bucket from higher frequencies to lower frequencies
    for (int i = bucket.length - 1; i >= 0; i--) {
      if (bucket[i] != null) {
        // Add numbers from bucket[i] to the answer array
        for (int j = 0; j < bucket[i].size(); j++) {
          ans[count++] = bucket[i].get(j);
          // Stop if we have added k elements to ans
          if (count == k)
            break;
        }
        if (count == k)
          break;
      }
    }
    // Return the final answer array
    return ans;
  }
}
