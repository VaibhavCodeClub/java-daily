// write a function that takes in a string and returns after reversing it

import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        System.out.print("Enter the string: ");
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        sc.close();
        System.out.println("Reversed string: " + rev(s));
    }

    private static String rev(String s) {
        String ret = "";
        for (int i = s.length()-1; i >= 0; i--) {
            ret += s.charAt(i);
        }
        return ret;
    }
}
