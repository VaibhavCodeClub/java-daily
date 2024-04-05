/*
    * 
   * * 
  * * * 
 * * * * 
* * * * * 
*/
public class pattern8 {
  public static void main(String[] args) {
    patternEight(5);
  }

  private static void patternEight(int num) {
    for (int i = 1; i <= 2*num; i += 2) {

      for (int j = 0; j < 2*num-i; j++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
logic