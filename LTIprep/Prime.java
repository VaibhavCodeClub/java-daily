import java.util.*;

public class Prime {

  public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    // int n = sc.nextInt();

    // for (int i = 2; i <= n; i++) {
    // boolean isPrime = true;

    // for (int j = 2; j <= Math.sqrt(i); j++) {
    // if (i % j == 0) {
    // isPrime = false;
    // break;
    // }
    // }
    // if (isPrime) System.out.println(i);
    // }
    // sc.close();

    int i = 19;
    // 2 3 4 5 6
    for (int j = 2; j < Math.sqrt(i); j++) {
      if (i % j == 0) {
        System.out.println("not prime");
        break;
      }
      else System.out.println("prime");
    }
  }
}
