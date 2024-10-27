// Find All Duplicates in an Array

// Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

// You must write an algorithm that runs in O(n) time and uses only constant extra space.

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class leet442 {
    public static void main(String args[]) {
        System.out.print(findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            int cc = count.getOrDefault(num, 0);
            count.put(num, cc + 1);
            if (cc + 1 == 2) {
                ret.add(num);
            }
        }
        return ret;
    }
}