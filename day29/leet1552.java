// Magnetic Force Between Two Balls
// In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.

// Rick stated that magnetic force between two different balls at positions x and y is |x - y|.

// Given the integer array position and the integer m. Return the required force.

import java.util.Arrays;

public class leet1552 {
  public static void main(String[] args) {
    System.out.println(maxDistance(new int[] { 1, 2, 3, 4, 7 }, 3));
  }

  private static boolean isPossible(int mid, int[] position, int m) {
    int prev = position[0];
    m--;
    for (int i = 1; i < position.length; i++) {
      if (position[i] - prev >= mid) {
        m--;
        prev = position[i];
      }
      if (m == 0)
        return true;
    }
    return false; 
  }

  public static int maxDistance(int[] position, int m) {
    Arrays.sort(position);

    int end = position[position.length - 1] - position[0];
    int start = 1;
    int ans = 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (isPossible(mid, position, m)) {
        ans = mid;
        start = mid + 1;
      } else
        end = mid - 1;
    }
    return ans;
  }

}