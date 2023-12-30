// Write a function that takes in a String and returns true if the String is empty, false otherwise.

import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str = sc.nextLine();
        sc.close();
        System.out.println(isEmpty(str));
    }

    private static boolean isEmpty(String str) {
        // return str.isEmpty();
        return str.length() == 0 ? true : false;
    }
}
