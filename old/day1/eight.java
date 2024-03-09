//  Write a function that takes string as input and returns the length

import java.util.Scanner;

public class eight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String c = sc.next();
        sc.close();

        System.out.println(length(c));
    }

    private static int length(String str) {
        return str.length();
    }
}
