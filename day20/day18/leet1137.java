// N-th Tribonacci Number
// The Tribonacci sequence Tn is defined as follows: 
// T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
// Given n, return the value of Tn.

public class leet1137 {
  public static void main(String[] args) {
    System.out.println(tribonacci(25));
  }

  public static int tribonacci(int n) {
    if (n == 0)
      return 0;
    if (n == 1 || n == 2)
      return 1;
    int first = 0, second = 1, third = 1;
    while (n > 2) {
      int temp = first + second + third;
      first = second;
      second = third;
      third = temp;
      n--;
    }
    return third;
  }
}
