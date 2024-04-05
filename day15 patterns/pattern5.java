/*
* 
* * 
* * * 
* * * * 
* * * * * 
* * * * 
* * * 
* * 
* 
*/
public class pattern5 {
  public static void main(String[] args) {
    patternOne(5);
  }

  private static void patternOne(int num) {
    for (int i = 1; i <= num * 2 - 1; i++) {
      int totalCols = i > num ? 2 * num - i : i;
      for (int j = 1; j <= totalCols; j++) {

        System.out.print("* ");

      }
      System.out.println();
    }
  }
}
