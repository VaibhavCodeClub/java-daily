// Write a function that takes in an array of numbers and returns a new array with each number multiplied by 2

import java.util.Arrays;
import java.util.Scanner;

public class six {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of array: ");
        int len = sc.nextInt();
        System.out.println("Enter array Elements: ");

        int arr[] = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(Arrays.toString(calculate(arr)));
    }

    private static int[] calculate(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 2;
        }

        return arr;
    }
}
