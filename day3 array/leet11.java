// Container With Most Water
// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.

public class leet11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }

    public static int maxArea(int[] height) {
        // Initialisation left at 0 and right at the end element of the array
        int left = 0, right = height.length - 1, maxArea = 0;

        while (left < right) {
            // loop until the left value is less than right one
            int area = Math.min(height[left], height[right]) * (right - left); //

            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
// Approach here start the left value at 0 and right value at the array length
// calculat ethe area of those values and store it now watch that if left is
// small or right is small if left is small then increase its value by 1 else
// decrease the right by 1 again calculate the area and check the area stored
// previously is greater or area calculated just now and at the end return the
// maxArea