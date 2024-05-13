import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxPointsInsideSquare(int[][] points, String s) {
        int n = points.length;

        for (int i = 0; i < n; i++) {
            points[i][0] = Math.abs(points[i][0]);
            points[i][1] = Math.abs(points[i][1]);
        }

        int l = 0;
        int r = (int) 1e9;
        int ans = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            Map<Character, Integer> m = new HashMap<>();
            int f = 1;

            for (int i = 0; i < n; i++) {
                if (points[i][0] <= mid && points[i][1] <= mid) {
                    m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
                }
            }

            for (Map.Entry<Character, Integer> entry : m.entrySet()) {
                if (entry.getValue() > 1) {
                    f = 0;
                    break;
                }
            }

            if (f == 1) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (points[i][0] <= ans && points[i][1] <= ans) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] points1 = {{2,2},{-1,-2},{-4,4},{-3,1},{3,-3}};
        String s1 = "abdca";
        System.out.println(solution.maxPointsInsideSquare(points1, s1)); // Output: 2
        
        int[][] points2 = {{1,1},{-2,-2},{-2,2}};
        String s2 = "abb";
        System.out.println(solution.maxPointsInsideSquare(points2, s2)); // Output: 1
        
        int[][] points3 = {{1,1},{-1,-1},{2,-2}};
        String s3 = "ccd";
        System.out.println(solution.maxPointsInsideSquare(points3, s3)); // Output: 0
    }
}
