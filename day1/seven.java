// Write a function that take stwo numbers and returns their sum

import java.util.Scanner;

public class seven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        sc.close();

        System.out.println(addition(a, b));
    }

    private static int addition(int a, int b) {
        return a + b;
    }
}
