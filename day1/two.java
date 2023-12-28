// Write an if statement that checks if a string is empty

import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String or press \"enter\" to keep empty: ");
        String s = sc.nextLine();
        // System.out.println(s.isEmpty());
        if (s.isEmpty())
            System.out.println("String is empty");
        else
            System.out.println("String is not empty");
        sc.close();
    }
}
