public class fibonacci {
  public static void main(String[] args) {
    System.out.println(0 + "\n" + 1);
    fibo(15, 2, 0, 1);
  }

  static void fibo(int n, int current, int prev1, int prev2) {
    if (current > n)
      return;
    int sum = prev1 + prev2;
    System.out.println(sum);
    prev1 = prev2;
    prev2 = sum;
    current++;

    fibo(n, current, prev1, prev2);
  }
}
