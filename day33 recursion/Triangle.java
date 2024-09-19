public class Triangle {

  public static void main(String[] args) {
    triangle(10, 0);
  }

  private static void triangle(int row, int col) {
    if (row == 0) return;
    if (col < row) {
      System.out.print("* ");
      col++;
    } else {
      System.out.println();
      row--;
      col = 0;
    }
    triangle(row, col);
  }
}
