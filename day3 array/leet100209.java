// Mark Elements on Array by Performing Queries

/*
You are given a 0-indexed array nums of size n consisting of positive integers.

You are also given a 2D array queries of size m where queries[i] = [indexi, ki].

Initially all elements of the array are unmarked.

You need to apply m queries on the array in order, where on the ith query you do the following:

    Mark the element at index indexi if it is not already marked.
    Then mark ki unmarked elements in the array with the smallest values. If multiple such elements exist, mark the ones with the smallest indices. And if less than ki unmarked elements exist, then mark all of them.

Return an array answer of size m where answer[i] is the sum of unmarked elements in the array after the ith query.

*/
    import java.util.*;

public class leet100209 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 1, 2, 3, 1 };
        int[][] queries = { { 1, 2 }, { 3, 3 }, { 4, 2 } };
        System.out.println(Arrays.toString(unmarkedSumArray(nums, queries)));
    }

    public static int[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] result = new int[queries.length];
        Arrays.fill(result, -1); // Initialize result array with -1 as a placeholder for unprocessed queries

        // Initialize set to track marked indices
        Set<Integer> markedIndices = new HashSet<>();
        // Initialize min heap to track unmarked elements by their values and indices
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                Comparator.comparingInt((int[] arr) -> arr[0]).thenComparingInt(arr -> arr[1]));

        // Initially, sum of unmarked elements equals sum of all elements
        int unmarkedSum = Arrays.stream(nums).sum();

        // Process each query
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int k = queries[i][1];

            // Mark the element at index indexi if it is not already marked
            if (!markedIndices.contains(index)) {
                markedIndices.add(index);
                unmarkedSum -= nums[index]; // Deduct marked element value from unmarked sum
            }

            // Mark ki unmarked elements in the array with the smallest values
            while (k > 0 && !minHeap.isEmpty()) {
                int[] elem = minHeap.poll();
                int elemIndex = elem[1];

                if (!markedIndices.contains(elemIndex)) {
                    markedIndices.add(elemIndex);
                    unmarkedSum -= elem[0]; // Deduct marked element value from unmarked sum
                    k--;
                }
            }

            // Store the sum of unmarked elements after the ith query
            result[i] = unmarkedSum;

            // Add unmarked elements after marking the current query's elements
            for (int j = 0; j < n; j++) {
                if (!markedIndices.contains(j)) {
                    minHeap.offer(new int[] { nums[j], j });
                }
            }
        }

        return result;
    }
}
