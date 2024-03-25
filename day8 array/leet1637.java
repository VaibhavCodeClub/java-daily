// Widest Vertical Area Between Two Points Containing No Points
// Given n points on a 2D plane where points[i] = [xi, yi], Return the widest vertical area between two points such that no points are inside the area.

// A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height). The widest vertical area is the one with the maximum width.

// Note that points on the edge of a vertical area are not considered included in the area.

import java.util.Arrays;
import java.util.Comparator;

public class leet1637 {
    public static void main(String[] args) {
        System.out.println(
                maxWidthOfVerticalArea(new int[][] { { 3, 1 }, { 9, 0 }, { 1, 0 }, { 1, 4 }, { 5, 3 }, { 8, 8 } }));
    }

    public static int maxWidthOfVerticalArea(int[][] points) {
        int max = 0;
        // This thing looks a bit complex
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                final int firstValue1 = entry1[0];
                final int firstValue2 = entry2[0];
                return firstValue1 - firstValue2;
            }
        });
        for (int i = 1; i < points.length; i++) {
            max = Math.max(max, Math.abs(points[i][0] - points[i - 1][0]));
        }
        return max;
    }

    // Faster and easier approach
    public int maxWidthOfVerticalArea0(int[][] points) {
        int brr[] = new int[points.length];
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            brr[i] = points[i][0];
        }
        Arrays.sort(brr);
        for (int i = 0; i < points.length - 1; i++) {
            res = Math.max(res, brr[i + 1] - brr[i]);
        }
        return res;

    }
}
