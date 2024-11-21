class Armstring {

    public static void main(String[] args) {
        int n = 153;
        // int len = String.valueOf(n).length();

        int len = 0;
        int temp = n;
        while (temp != 0) {
            temp /= 10;
            len++;
        }

        int x = n;
        int sum = 0;

        while (x != 0) {
            int digit = x % 10;
            sum += Math.pow(digit, len);
            x /= 10;
        }

        if (n == sum) {
            System.out.println("armstrong");
        } else {
            System.out.println("not armstrong");
        }
    }
}
