// DI String Match
/*
A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:
    s[i] == 'I' if perm[i] < perm[i + 1], and
    s[i] == 'D' if perm[i] > perm[i + 1].

Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return any of them.
*/

// Above is worst problem description so below is better from disscussion section

/*
basically you just need to simply run D towards decrement from the length of s and I towards increment. That is if s="DDD" then output is [3,2,1,0] where first 3 of array is denoting length of s and being decrementd by 1 each time when "D" occurs again. if there was I also, lets suppose "DIIIDI" then D will be decrementing and I will be incrementing by1. output => [6,0,1,2,5,3,4].

Note :- D will start from the length of s and will be decreasing by 1 whenever "D" occurs again, and I will start from 0 and will be increasing by 1 whenever "I" occurs again. at the end I and D will be on same position so just push any of them in to the array at the end, and you will get your output.
*/

import java.util.Arrays;

public class leet942 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(diStringMatch("DIIIDI")));
  }

  public static int[] diStringMatch(String s) {
    int[] finalSolution = new int[s.length() + 1];
    int i = 0, d = s.length(), indes = 0;

    for (char ch : s.toCharArray()) {
      if (ch == 'I') {
        finalSolution[indes++] = i++;
        // i++;
      } else
        finalSolution[indes++] = d--;
    }
    finalSolution[indes] = d;
    return finalSolution;
  }
}
