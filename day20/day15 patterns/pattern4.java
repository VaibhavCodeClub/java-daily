/*
1 
1 2 
1 2 3 
1 2 3 4 
1 2 3 4 5
*/
public class pattern4 {
  public static void main(String[] args) {
    patternOne(5);
  }

  private static void patternOne(int num) {
    for (int i = 1; i <= num; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }
}
