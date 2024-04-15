// Trapping Rain Water
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

public class leet42 {

  public static void main(String[] args) {
    System.out.println(getMin(new int[] { 3, 1, 2, 4, 0, 1, 3, 2 }));
  }

  private static int getMin(int[] is) {
    int n = is.length;
    int left[] = new int[n];
    int right[] = new int[n];

    left[0] = is[0];
    for (int i = 1; i < n; i++) {
      left[i] = Math.max(left[i - 1], is[i]);
    }
    right[n - 1] = is[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      right[i] = Math.max(right[i + 1], is[i]);
    }

    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans += (Math.min(left[i], right[i]) - is[i]);
    }
    return ans;
  }
}