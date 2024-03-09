// Write a function that takes an array of numbers and returns the sum of numbers.

import java.util.Scanner;

public class four {
    public static void main(String[] args) {
        System.out.print("Enter the length of array: ");
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();

        int[] arr = new int[len];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(sumOfNumbers(len, arr));
    }

    private static int sumOfNumbers(int len, int[] arr) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
