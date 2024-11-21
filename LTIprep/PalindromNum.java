class PalindromNum {

    public static void main(String args[]) {
        int num = 123321;

        int rev = 0;
        int temp = num;
        while (temp != 0) {
            rev = rev * 10 + (temp % 10);
            temp /= 10;
        }
        if (rev == num) {
            System.out.println("palindrome");
        } else {
            System.out.println("not palindrome");
        }
    }
}
