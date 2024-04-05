/*
        * 
      * * 
    * * * 
  * * * * 
* * * * *
*/
public class pattern6 {
  public static void main(String[] args) {
    patternSix(5);

  }

  private static void patternSix(int num) {
    for (int i = 1; i <= num; i++) {
      int numberOfSpaces = num - i;
      for (int j = 1; j <= numberOfSpaces; j++) {
        System.out.print("  ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}
