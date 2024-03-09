// Missing Number

// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.


// Used simple approach just added all the elements to the HashMap and returned missing element using for loop
import java.util.HashSet;

public class leet268 {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] { 8, 6, 4, 2, 3, 5, 7, 0, 1 }));
    }

    public static int missingNumber(int[] nums) {
        // Create new empty HashSet
        HashSet<Integer> set = new HashSet<>();
        for (int iterable : nums) {
            // Copy everything from that array to set
            set.add(iterable);
        }
        for (int i = 0; i < nums.length + 1; i++) {
            // Iterate through the entire array
            if (!set.contains(i)) {
                // Check if that set contains i or not if not return the i
                return i;
            }
        }
        return -1;
    }
}
