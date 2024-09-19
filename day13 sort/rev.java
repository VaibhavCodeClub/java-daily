public class rev {

  public static void main(String[] args) {
    String s = "Vaibhav";

    StringBuilder sb = new StringBuilder(s);

    sb.reverse();
    s = sb.toString();

    System.out.print(s);
  }
}
