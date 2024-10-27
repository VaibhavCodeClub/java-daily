/*
You are given n arrays a1, …, an. The length of each array is two. Thus, ai=[ai,1,ai,2]. You need to concatenate the arrays into a single array of length 2n such that the number of inversions†

in the resulting array is minimized. Note that you do not need to count the actual number of inversions.

More formally, you need to choose a permutation‡
p of length n, so that the array b=[ap1,1,ap1,2,ap2,1,ap2,2,…,apn,1,apn,2]

contains as few inversions as possible.

†
The number of inversions in an array c is the number of pairs of indices i and j such that i<j and ci>cj

.

‡
A permutation of length n is an array consisting of n distinct integers from 1 to n in arbitrary order. For example, [2,3,1,5,4] is a permutation, but [1,2,2] is not a permutation (2 appears twice in the array), and [1,3,4] is also not a permutation (n=3 but there is 4

in the array).
Input

Each test consists of multiple test cases. The first line contains a single integer t
(1≤t≤104

) — the number of test cases. The description of the test cases follows.

The first line of each test case contains a single integer n
(1≤n≤105

) — the number of arrays.

Each of the following n
lines contains two integers ai,1 and ai,2 (1≤ai,j≤109) — the elements of the i

-th array.

It is guaranteed that the sum of n
over all test cases does not exceed 105

.
Output

For each test case, output 2n
integers — the elements of the array you obtained. If there are multiple solutions, output any of them.
*/
import java.util.*;

public class MinimizeInversions {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt(); // Number of test cases

    while (t-- > 0) {
      int n = sc.nextInt(); // Number of arrays
      List<int[]> arrays = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();

        // Ensure that a1 <= a2
        if (a1 > a2) {
          int temp = a1;
          a1 = a2;
          a2 = temp;
        }

        arrays.add(new int[] { a1, a2 });
      }

      // Sort the arrays by the first element
      arrays.sort(Comparator.comparingInt(o -> o[0]));

      // Output the concatenated result
      StringBuilder result = new StringBuilder();
      for (int[] array : arrays) {
        result.append(array[0]).append(" ").append(array[1]).append(" ");
      }

      System.out.println(result.toString().trim());
    }

    sc.close();
  }
}
