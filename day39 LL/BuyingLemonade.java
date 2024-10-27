import java.util.Arrays;
import java.util.Scanner;

public class BuyingLemonade {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int t = scanner.nextInt();
    StringBuilder output = new StringBuilder();

    for (int i = 0; i < t; i++) {
      int n = scanner.nextInt();
      long k = scanner.nextLong();
      long[] a = new long[n];

      for (int j = 0; j < n; j++) {
        a[j] = scanner.nextLong();
      }

      Arrays.sort(a);
      long presses = 0;
      long collected = 0;

      for (int j = n - 1; j >= 0; j--) {
        if (collected >= k) {
          break;
        }

        long cansToTake = Math.min(a[j], k - collected);
        collected += cansToTake;
        presses += cansToTake;
        if (cansToTake < a[j]) {
          presses++;
        }
      }

      if (collected < k) {
        presses += (k - collected);
      }

      output.append(presses).append("\n");
    }

    System.out.print(output);
    scanner.close();
  }
}
