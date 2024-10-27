import java.util.*;

public class first {

  public static void main(String args[]) {
    System.out.println(generateSeries(2, 3, 100));
  }

  public static List<Integer> generateSeries(int A1, int R, int Z) {
    List<Integer> series = new ArrayList<>();
    int term = A1;

    while (term <= Z) {
      series.add(term);
      term *= R;
    }

    return series;
  }
}
