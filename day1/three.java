// Write an if-else statement to check if number is even or odd

import java.util.Scanner;

public class three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = sc.nextInt();
        sc.close();
        if (a % 2 == 0)
            System.out.println("The number is even");
        else
            System.out.println("The number is odd");
    }
}
