// write  a function that takes an array of numbers and returns average of the numbers

import java.util.Scanner;

public class three {
    public static void main(String[] args) {
        System.out.print("Enter the length of array: ");
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int arr[] = new int[len];

        System.out.print("Enter array elements: ");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        System.out.println("Average is: " + avg(len, arr));
    }

    private static double avg(double len, int[] arr) {
        double sum = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
        }
        return sum / len;
    }
}
