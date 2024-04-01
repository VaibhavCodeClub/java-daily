// Search a 2D Matrix
/*
You are given an m x n integer matrix matrix with the following two properties:

    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.

Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
*/

public class leet74 {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } }, 61));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && matrix[i][len - 1] >= target) {
                return binarySearch(matrix[i], target, len);
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] is, int target, int len) {
        int start = 0, end = len - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (is[mid] == target)
                return true;
            else if (is[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
