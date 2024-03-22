// Number of Steps to Reduce a Number to Zero
// Given an integer num, return the number of steps to reduce it to zero.

// In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
public class leet1342 {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(123));
        System.out.println(numberOfSteps2(123));
    }

    public static int numberOfSteps(int num) {
        // simple approach to solve the problem
        int count = 0;
        while (num > 0) {
            num = num % 2 == 0 ? num / 2 : num - 1;
            count++;
        }
        return count;
    }

    public static int numberOfSteps2(int num) {
        // binary approach to solve the problem
        int count = 0;
        while (num > 0) {
            // Here we are using bitmask and using and operator to check if the rightmost
            // element is 0 or 1 if it is 1 then just negate it as the number is odd else
            // right shift the binary value of num as it makes num half
            num = (num & 1) == 0 ? num >>= 1 : num - 1;
            count++;
        }
        return count;
    }
}
// Time complexity is O(logn)
// Space complexity is constant O(1)