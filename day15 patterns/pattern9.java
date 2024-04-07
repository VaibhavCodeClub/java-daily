/*
*********
 *******
  *****
   ***
    *
*/
public class pattern9 {
  public static void main(String[] args) {
    patternNine(5);
  }

  private static void patternNine(int num) {
    for (int i = num; i >0; i--) {

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
