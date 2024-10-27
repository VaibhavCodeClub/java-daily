//Fibonacci Number
/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.

Given n, calculate F(n).
 */
class leet509 {

  public static void main(String[] args) {
    System.out.println(fib(4));
  }

  public static int fib(int n) {
    int first = 0, second = 1;
    if (n == 0)
      return first;
    if (n == 1)
      return second;
    while (n > 0) {
      int temp = first;
      first = second;
      second = first + temp;
      n--;
    }
    return first;
  }

}