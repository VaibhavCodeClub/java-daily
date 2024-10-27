/*
        1 
      2 1 2 
    3 2 1 2 3 
  4 3 2 1 2 3 4 
5 4 3 2 1 2 3 4 5 
 */
public class pattern30 {
  public static void main(String[] args) {
    pattern(5);
  }

  private static void pattern(int i) {
    for (int row = 1; row <= i; row++) {
      for (int spaces = 0; spaces < i - row; spaces++) {
        System.out.print("  ");
      }
      for (int col = row; col >= 1; col--) {
        System.out.print(col + " ");
      }
      for (int col = 2; col <= row; col++) {
        System.out.print(col + " ");
      }
      System.out.println();
    }
  }
}
