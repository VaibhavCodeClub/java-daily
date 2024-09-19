import java.util.Scanner;

public class SecondLargestElement {

  public static void findSecondLargest(int[] arr) {
    // If the array has fewer than 2 elements, there's no second largest element
    if (arr.length < 2) {
      return;
    }

    int firstLargest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;

    // Find the largest and second largest elements
    for (int num : arr) {
      if (num > firstLargest) {
        secondLargest = firstLargest;
        firstLargest = num;
      } else if (num > secondLargest && num != firstLargest) {
        secondLargest = num;
      }
    }

    // If secondLargest is still MIN_VALUE, there was no second largest element
    if (secondLargest == Integer.MIN_VALUE) {
      return;
    }

    // Count how many times the second largest element appears in the array
    int count = 0;
    for (int num : arr) {
      if (num == secondLargest) {
        count++;
      }
    }

    System.out.println("The second largest element is: " + secondLargest);
    System.out.println("It appears " + count + " time(s).");
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    findSecondLargest(arr);
    sc.close();
  }
}
