// write a function that takes in a number and returns the factorial of that number

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println("factorial is: " + factorial(n));
    }

    private static int factorial(int n) {
        int sum = 1;
        // for (int i = 1; i <= n; i++) {
        // sum *= i;
        // }
        while (n != 1) {
            sum *= n;
            n--;
        }
        return sum;
    }
}
