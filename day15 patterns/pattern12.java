/*
* * * * * 
 * * * * 
  * * * 
   * * 
    * 
*/
public class pattern12 {
  public static void main(String[] args) {
    patternEight(5);
  }

  private static void patternEight(int num) {
    for (int i = 1; i <= num; i++) {

     if (i<num) {
       for (int j = 1; j < i; j++) {
         System.out.print(" ");
       }
       for (int j = num; j >= i; j--) {
         System.out.print("* ");
       }  
     }    

      else {
        for (int j = 1; j <= num - i; j++) {
          System.out.print(" ");
        }
        for (int j = 1; j <= i; j++) {
          System.out.print("* ");
        }
      }
      System.out.println();
    }
  }
}
