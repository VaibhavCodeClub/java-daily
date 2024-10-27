/*
* * * * * 
* * * * 
* * * 
* * 
* 
*/
public class pattern3 {
  public static void main(String[] args) {
    patternOne(5);
  }

  private static void patternOne(int num) {
    for (int i = num; i >= 1; i--) {
      for (int j = i; j >= 1; j--) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}
