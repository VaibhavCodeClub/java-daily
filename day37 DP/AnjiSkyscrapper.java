/*
You are given an array A of N integers, representing the maximum heights of N skyscrapers to be built.

Your task is to specify the actual heights of the skyscrapers, given that:

 - the height of the K-th skyscraper should be positive and not bigger than A[K];
 - no two skyscrapers should be of the same height;
 - the total sum of the skyscrapers' heights should be the maximum possible.

Write a function:
class Solution { public int[] solution(int[] A); }

that, given an array A of N integers, returns an array B of N integers where B[K] is the assigned height of the K-th skyscraper satisfying the above conditions.

If there are several possible answers, the function may return any of them. You may assume that it is always possible to build all skyscrapers while fulfilling all the requirements.
Examples:
1. Given A = [1, 2, 3], your function should return [1, 2, 3], as all of the skyscrapers may be built to their maximum height.

2. Given A = [9, 4, 3, 7, 7], your function may return [9, 4, 3, 7, 6]. Note that [9, 4, 3, 6, 7] is also a valid answer. It is not possible for the last two skyscrapers to have the same height. The of height of one of them should be 7 and the other should be 6.

3. Given A [2, 5, 4, 5, 5], your function should return [1, 2, 3, 4, 5]

Write an efficient algorithm for the following assumptions:
- N is an integer within the range [1..50,000];

- each element of array A is an integer within the range [1..1,000,000,000];
- there is always a solution for the given input.
*/
import java.util.*;

public class AnjiSkyscrapper {

  public int[] solution(int[] A) {
    int N = A.length;
    int[] B = new int[N];

    // Step 1: Create an array of original indices and max heights
    int[][] ind = new int[N][2];
    for (int i = 0; i < N; i++) {
      ind[i][0] = i; // Store the original index
      ind[i][1] = A[i]; // Store the max height
    }

    // Step 2: Sort the skyscrapers by their max height in descending order
    Arrays.sort(ind, (a, b) -> Integer.compare(b[1], a[1]));

    // Step 3: Assign heights ensuring no duplicates and maximizing the sum
    int last = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      int ori = ind[i][0]; // Get the original index
      int maxHeight = ind[i][1]; // Get the max height

      if (maxHeight < last) {
        B[ori] = maxHeight; // Assign the max height if it's smaller than the last height
        last = maxHeight; // Update the last height
      } else {
        B[ori] = last - 1; // Otherwise, assign the next smaller height
        last--; // Decrease the last height for the next skyscraper
      }
    }

    return B;
  }

  public static void main(String[] args) {
    AnjiSkyscrapper sol = new AnjiSkyscrapper();

    // Example 1
    int[] A1 = { 1, 2, 3 };
    System.out.println(Arrays.toString(sol.solution(A1))); // [1, 2, 3]

    // Example 2
    int[] A2 = { 9, 4, 3, 7, 7 };
    System.out.println(Arrays.toString(sol.solution(A2))); // [9, 4, 3, 7, 6]

    // Example 3
    int[] A3 = { 2, 5, 4, 5, 5 };
    System.out.println(Arrays.toString(sol.solution(A3))); // [1, 2, 3, 4, 5]
  }
}
