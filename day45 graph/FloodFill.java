/*
733. Flood Fill
You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill:
    Begin with the starting pixel and change its color to color.
    Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
    Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
    The process stops when there are no more adjacent pixels of the original color to update.

Return the modified image after performing the flood fill.*/
import java.util.*;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        image = floodFill(image, 0, 0, 0);
        for (int[] arr : image) System.out.println(Arrays.toString(arr));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length, m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        int iniColor = image[sr][sc];
        int delRow[] = { 0, 1, 0, -1 };
        int delCol[] = { 1, 0, -1, 0 };

        dfs(sr, sc, image, color, iniColor, delRow, delCol, vis);
        return image;
    }

    private static void dfs(
        int row,
        int col,
        int[][] image,
        int newColor,
        int prev,
        int[] delRow,
        int delCol[],
        boolean[][] vis
    ) {
        vis[row][col] = true;
        image[row][col] = newColor;

        int n = image.length, m = image[0].length;

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if (
                nRow >= 0 &&
                nRow < n &&
                nCol >= 0 &&
                nCol < m &&
                !vis[nRow][nCol] &&
                image[nRow][nCol] == prev
            ) {
                dfs(nRow, nCol, image, newColor, prev, delRow, delCol, vis);
            }
        }
    }

    public static int[][] floodFillAlgo(
        int[][] image,
        int sr,
        int sc,
        int newColor
    ) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private static void fill(
        int[][] image,
        int sr,
        int sc,
        int color,
        int newColor
    ) {
        if (
            sr < 0 ||
            sr >= image.length ||
            sc < 0 ||
            sc >= image[0].length ||
            image[sr][sc] != color
        ) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
}
