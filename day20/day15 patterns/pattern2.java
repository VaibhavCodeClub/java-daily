/*
* 
* * 
* * * 
* * * * 
* * * * *
*/

public class pattern2 {
  public static void main(String[] args) {
    patternOne(5);
  }

  private static void patternOne(int num) {
    for (int i = 1; i <= num; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}
