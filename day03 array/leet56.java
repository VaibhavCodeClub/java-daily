// Merge Intervals
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet56 {
    public static void main(String[] args) {
        System.out.println(merge(new int[][] { { 2, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } }));
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>(); // Create an empty list to return
        if (intervals.length == 0 || intervals == null)
            // If the input array is empty or null return empty res
            return res.toArray(new int[0][]);

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // else sort the input array
        int start = intervals[0][0]; // define start as the 0th index of the first array
        int end = intervals[0][1]; // define the end index as the 1st element of the first array

        for (int[] is : intervals) {
            // for each arrray in intervals
            if (is[0] <= end) {
                // if the 0th indes of that array is less than or equal to the end declared
                // above
                end = Math.max(end, is[1]); // get max from that 2 end integers and save it in end
                // This is the merging of two arrays

            } else {
                // else add that array as it is to the returning array
                res.add(new int[] { start, end });
                start = is[0]; // and declare the start and end as current array's values
                end = is[1];
            }
        }
        res.add(new int[] { start, end }); // at the end add the remaining start and end (last array) to the returning
                                           // array
        return res.toArray(new int[0][]); // return that returning array list b converting to the 2d array
    }
}
