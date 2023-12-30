// Write a function that takes an array of strings and returns the length of the longest string

import java.util.Arrays;
import java.util.Scanner;

public class five {
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
        System.out.println(getMax(arr));
    }

    private static int getMax(String[] arr) {
        int max = 0;
        if (arr.length != 0)
            max = arr[1].length();
        else
            return 0;
        for (String string : arr) {
            if (string.length() > max)
                max = string.length();
        }
        return max;
    }
}
