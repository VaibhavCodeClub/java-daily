public class Fibo {
  public static void main(String[] args) {
    System.out.println(fibo(7));

  }

  // 0 1 1 2 3 5 8 13
  // 0 1 2 3 4 5 6 7
  static int fibo(int i) {
    if (i <= 1)
      return i;
    return fibo(i - 1) + fibo(i - 2);
  }
}
