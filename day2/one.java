// Write a function that takes a number and returns true if the number is even, false if it is odd.

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = sc.nextInt();
        sc.close();
        System.out.println(oddEven(a));
    }

    private static boolean oddEven(int a) {
        return a % 2 == 0;
    }
}