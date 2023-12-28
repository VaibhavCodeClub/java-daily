// Write an if statement that checks if a number is greater than 5.

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = sc.nextInt();
        System.out.println(a > 5 ? "greater" : "smaller or equal to");
        sc.close();
    }
}