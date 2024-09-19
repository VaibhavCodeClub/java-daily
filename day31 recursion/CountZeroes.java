public class CountZeroes {

  public static void main(String args[]) {
    System.out.print(countZeroes(1010101, 0));
  }

  private static int countZeroes(int i, int count) {
    if (i == 0) return count;
    int rem = i % 10;

    if (rem == 0) count++;
    return countZeroes(i / 10, count);
  }
}
