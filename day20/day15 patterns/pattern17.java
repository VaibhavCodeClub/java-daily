/*
        1 
      2 1 2 
    3 2 1 2 3 
  4 3 2 1 2 3 4 
5 4 3 2 1 2 3 4 5 
  4 3 2 1 2 3 4 
    3 2 1 2 3 
      2 1 2 
        1 
 */
public class pattern17 {
  public static void main(String[] args) {
    pattern(5);
  }

  private static void pattern(int i) {
    for (int row = 1; row <= 2 * i; row++) {
      int c = row > i ? 2 * i - row : row;
      for (int spaces = 0; spaces < i - c; spaces++) {
        System.out.print("  ");
      }
      for (int col = c; col >= 1; col--) {
        System.out.print(col + " ");
      }
      for (int col = 2; col <= c; col++) {
        System.out.print(col + " ");
      }
      System.out.println();
    }
  }
}
