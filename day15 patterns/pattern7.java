/*
* * * * * 
  * * * * 
    * * * 
      * * 
        * 
*/
public class pattern7 {
  public static void main(String[] args) {
    patternSeven(5);
  }

  private static void patternSeven(int num) {
    for (int i = 1; i <= num; i++) {
      for (int j = 1; j < i; j++) {
        System.out.print("  ");
      }
      for (int j = num; j >= i; j--) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}
