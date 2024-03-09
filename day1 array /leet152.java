// Maximum Product Subarray
// Given an integer array nums, find a subarray that has the largest product, and return the product. The test cases are generated so that the answer will fit in a 32-bit integer.

public class leet152 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[] { 2, 3, -2, -5, 6, -1, 4 }));
    }

    public static int maxProduct(int[] nums) {
        // int maxProduct = nums[0], curMax = nums[0], curMin = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        // if (nums[i] < 0) {
        // curMax += curMin;
        // curMin = curMax - curMin;
        // curMax = curMax - curMin;
        // // int temp = curMax;
        // // curMax = curMin;
        // // curMin = temp;
        // }
        // curMax = Math.max(nums[i], curMax * nums[i]);
        // curMin = Math.min(nums[i], curMin * nums[i]);
        // maxProduct = Math.max(curMax, maxProduct);
        // }
        // return maxProduct;

        int n = nums.length; // Grab the length of the array
        int leftProduct = 1; // left product as 1
        int rightProduct = 1;
        int ans = nums[0]; // Initially answer is first element
        for (int i = 0; i < n; i++) {// Iterate through
            leftProduct = leftProduct == 0 ? 1 : leftProduct; // If 0 turn it to 1 else everything will be turned into 0
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            leftProduct *= nums[i]; // Keep going using multiplication from left to right
            rightProduct *= nums[n - 1 - i]; // Keep going from right to left
            ans = Math.max(ans, Math.max(leftProduct, rightProduct)); // Grab the max from current ans and left
                                                                      // product and right product
        }
        return ans;
    }
}
