/*WeaponBoxes
Problem Description

In the border of India, there is a military camp where soldiers stay. The soldiers need weapons during the wars and some weapons are made in India while the others are imported from other countries. One day many boxes of weapons arrived from different countries. These boxes have different numbers assigned to it. These numbers denotes the weight of the boxes. Larger the number on the box, the more will be the weapons inside it. All these boxes are arranged in a line starting from the camp. One day the commander wanted to test the weapons in all the boxes one by one. But he wanted to prioritize the boxes with more weight because when he open that box, the number of weapons will be more. So he will followed the below steps.

    He will carry this process in cycles. In each cycle, he will select the first N boxes. From those, every time he will pick the first two boxes and compare them and send the box with lower weight to the end of the line.
    At last one box will remain from those N boxes, then the cycle is said to be complete.
    He halts this process when the same box remains un-shifted to the end of the line in K consecutive cycles.
    For shifting these boxes, he hired labors and they will charge an amount which is equal to the sum of weights of all those boxes except those which are having triangular number weights.

Given an array consisting of weights of all the boxes, two integers N and K, print the amount of money that the commander have to give to workers.

Constraints

1 <= weight of each box <= 10^5

1 <= number of boxes <= 10^4

1 <= N,K <= 10^3

All the elements in the array are distinct.

Input

First line consists of an array denoting the weight of all the boxes.

Second line consists of two space separated integers N and K, denoting the number of boxes he selects in each cycle and number of times a box should remain un-shifted to halt the process.

Output

Print the amount of money that the commander have to give to workers.

Time Limit (secs)

1

Examples

Example 1

Input

7 3 6 9 10 2 4 11 5 12 17 1

3 2

Output
22

After cycle 3, 10 remained un-shifted in 2 cycles. Hence he halts the process.

Total amount need to be paid for the labor = sum of non triangular weights of all the shifted boxes = 7 + 9 + 2 + 4 = 22
Example 2

Input

6 2 8 14 5 1 3

2 2

Output

15
After cycle 4, 14 remained un-shifted for 2 cycles. Hence he halts the process.

Total amount need to be paid for the labor = sum of non triangular weights of all the shifted boxes = 2 + 8 + 5 = 15.
*/

import java.util.*;

public class WeaponBoxes {

  private List<Integer> boxes;
  private int n;
  private int k;

  public WeaponBoxes(List<Integer> boxes, int n, int k) {
    this.boxes = new ArrayList<>(boxes);
    this.n = n;
    this.k = k;
  }

  public int calculateLabourCost() {
    int consecutiveUnshifted = 0;
    int cycles = 0;
    Set<Integer> shiftedBoxes = new HashSet<>();

    while (consecutiveUnshifted < k) {
      if (boxes.size() < n) {
        n = boxes.size(); // Adjust N if there are fewer boxes left
      }

      int initialFirstBox = boxes.get(0);
      List<Integer> currentCycle = new ArrayList<>(boxes.subList(0, n));

      for (int i = 0; i < n / 2; i++) {
        if (2 * i + 1 < currentCycle.size()) {
          int box1 = currentCycle.get(2 * i);
          int box2 = currentCycle.get(2 * i + 1);

          if (box1 < box2) {
            shiftedBoxes.add(box1);
          } else {
            shiftedBoxes.add(box2);
          }
        }
      }

      // Keep the remaining box in the front
      List<Integer> remainingBoxes = new ArrayList<>(
        boxes.subList(n, boxes.size())
      );
      if (n % 2 == 1) {
        remainingBoxes.add(currentCycle.get(currentCycle.size() - 1)); // Add last unpaired box
      }
      boxes = new ArrayList<>(remainingBoxes);

      // Check if the first box is unshifted
      if (boxes.isEmpty() || boxes.get(0) != initialFirstBox) {
        consecutiveUnshifted = 0;
      } else {
        consecutiveUnshifted++;
      }
      cycles++;
    }

    return calculateNonTriangularSum(shiftedBoxes);
  }

  private int calculateNonTriangularSum(Set<Integer> shiftedBoxes) {
    int sum = 0;
    for (int box : shiftedBoxes) {
      if (!isTriangular(box)) {
        sum += box;
      }
    }
    return sum;
  }

  private boolean isTriangular(int num) {
    int n = (int) Math.sqrt(2 * num);
    return (n * (n + 1)) / 2 == num || ((n + 1) * (n + 2)) / 2 == num;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Read input
    String[] boxWeights = scanner.nextLine().split(" ");
    List<Integer> boxes = new ArrayList<>();
    for (String weight : boxWeights) {
      boxes.add(Integer.parseInt(weight));
    }

    int n = scanner.nextInt();
    int k = scanner.nextInt();

    WeaponBoxes sorter = new WeaponBoxes(boxes, n, k);
    int labourCost = sorter.calculateLabourCost();

    System.out.println(labourCost);
    scanner.close();
  }
}
