// Find the Sum of Encrypted Integers

/*
You are given an integer array nums containing positive integers. We define a function encrypt such that encrypt(x) replaces every digit in x with the largest digit in x. For example, encrypt(523) = 555 and encrypt(213) = 333.

Return the sum of encrypted elements.
*/

public class leet100262 {
    public static void main(String[] args) {
       System.out.println(sumOfEncryptedInt(new int[] { 10, 21, 31 }));
    }

    public static int encrypt(int x) {
        String strX = Integer.toString(x);
        char maxDigit = '0';
        for (char digit : strX.toCharArray()) {
            if (digit > maxDigit) {
                maxDigit = digit;
            }
        }
        return Integer.parseInt(String.valueOf(maxDigit).repeat(strX.length()));
    }

    public static int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += encrypt(num);
        }
        return sum;
    }
}
