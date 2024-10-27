/*
    *
   ***
  *****
 *******
*********
*/
public class pattern8 {
  public static void main(String[] args) {
    patternEight(5);
  }

  private static void patternEight(int num) {
    for (int i = 1; i <= num; i++) {

      for (int j = 1; j <= num - i; j++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= 2 * i - 1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
