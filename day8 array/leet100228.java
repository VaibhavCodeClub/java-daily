// Apply Operations to Make Sum of Array Greater Than or Equal to k
/*
 * You are given a positive integer k. Initially, you have an array nums = [1].

You can perform any of the following operations on the array any number of times (possibly zero):

    Choose any element in the array and increase its value by 1.
    Duplicate any element in the array and add it to the end of the array.

Return the minimum number of operations required to make the sum of elements of the final array greater than or equal to k.
 */
public class leet100228 {
    public static void main(String[] args) {
        System.out.println(minOperations(11)); // Output: 5
        System.out.println(minOperations(1));  // Output: 0
        System.out.println(minOperations(3));  // Output: 2
    }

    public static int minOperations(int k) {
        if (k == 1) {
            return 0; // Base case: If k is 1, no operations are needed
        }

        // Count the number of bits needed to represent k
        int bits = 0;
        int num = k;
        while (num > 0) {
            num /= 2;
            bits++;
        }

        // If k is a power of 2, no additional operation is needed
        if ((1 << (bits - 1)) == k) {
            return bits - 1;
        } else {
            // If k is not a power of 2, one additional operation is needed to reach the next power of 2
            return bits;
        }
    }}