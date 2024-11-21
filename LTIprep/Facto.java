public class Facto {
  public static void main(String[] args) {
    int i = 5;
    int sum = 1;

    for (int j = 2; j <=i; j++) {
      sum *= j;
    }
    System.out.println(sum);
  }
}
