// Find the Child Who Has the Ball After K Seconds
// You are given two positive integers n and k. There are n children numbered from 0 to n - 1 standing in a queue in order from left to right.

// Initially, child 0 holds a ball and the direction of passing the ball is towards the right direction. After each second, the child holding the ball passes it to the child next to them. Once the ball reaches either end of the line, i.e. child 0 or child n - 1, the direction of passing is reversed.0

// Return the number of the child who receives the ball after k seconds.

public class leet100325 {
  public static void main(String[] args) {
    System.out.println(numberOfChild(4, 2));
  }

  public static int numberOfChild(int n, int k) {
    int cycleLength = 2 * (n - 1);
    int position = k % cycleLength;

    if (position < n) {
      return position;
    } else {
      return cycleLength - position;
    }
  }
}
