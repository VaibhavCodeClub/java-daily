// Write a function that takes in an array of Strings and returns a new array with each String capitalized

import java.util.Arrays;
import java.util.Scanner;

public class seven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the lenth of Array: ");
        int len = sc.nextInt();
        String arr[] = new String[len];

        System.out.println("Enter array elements: ");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.next();
        }
        sc.close();
        System.out.println(Arrays.toString(toUpper(arr)));
    }

    private static String[] toUpper(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].toUpperCase();
        }
        return arr;
    }
}
