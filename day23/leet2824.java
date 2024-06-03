// Count Pairs Whose Sum is Less than Target

import java.util.ArrayList;
import java.util.List;

public class leet2824 {
  public static void main(String[] args) {
    List<Integer> intList = new ArrayList<>();
    intList.add(-6);
    intList.add(2);
    intList.add(5);
    intList.add(-2);
    intList.add(-7);
    intList.add(-1);
    intList.add(3);
    System.out.println(countPairs(intList, -2));
  }

  public static int countPairs(List<Integer> nums, int target) {
    int count = 0;
    for (int i = 0; i < nums.size() - 1; i++)
      for (int j = i + 1; j < nums.size(); j++)
        if (nums.get(i) + nums.get(j) < target)
          count++;
    return count;
  }
}
