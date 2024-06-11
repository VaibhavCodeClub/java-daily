// Maximum Total Reward Using Operations I
/*
You are given an integer array rewardValues of length n, representing the values of rewards.

Initially, your total reward x is 0, and all indices are unmarked. You are allowed to perform the following operation any number of times:

    Choose an unmarked index i from the range [0, n - 1].
    If rewardValues[i] is greater than your current total reward x, then add rewardValues[i] to x (i.e., x = x + rewardValues[i]), and mark the index i.

Return an integer denoting the maximum total reward you can collect by performing the operations optimally.

Example:

Input: rewardValues = [1,6,4,3,2]
Output: 11
Explanation:
Mark the indices 0, 2, and 1 in order. The total reward will then be 11, which is the maximum.

*/

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TrieNode {
  TrieNode[] children;

  TrieNode() {
    children = new TrieNode[10]; // Assuming reward values are non-negative integers less than 10
  }
}

public class leet100319 {
  public static void main(String[] args) {
    System.out.println(maxTotalReward(new int[] { 1, 6, 4, 3, 2 }));
  }

  public static int maxTotalReward(int[] rewardValues) {
    Arrays.sort(rewardValues);
    Set<Integer> pSums = new HashSet<>();
    pSums.add(0);
    for (int reward : rewardValues) {
        Set<Integer> nSums = new HashSet<>(pSums);
        for (int s : pSums) {
            if (reward > s) {
                nSums.add(s + reward);
            }
        }
        pSums = nSums;
    }
    return Collections.max(pSums);
  }
}
