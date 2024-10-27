/*

Pune Football Club is playing to try to advance to the next round. Pune needs at least of P more points to go to the next round in their remaining Q matches following is the points distribution

win 2 points
tie 1 pont
loss 0 point

To go to the next round find the how many matches Pune needs to win

Input:

First line will contain T, number of testcases. Then the testcases will be mentioned in the following lines
Each testcase contains of a single line of input, two space separated integers P and Q

Output:

For each test case, output in a single line the number of matches Pune must win to go to next round write a program to take values of T, P and Q from user and print the expected output

Example
input
2
10 5
1 5

Output
5
0

Explanation:
in first case P=10 Q=5, so Pune needs 10 points from remaining 5 matches to go to next round, it is only possible if they win all their remaining matches
In second case P=1 and Q=5, so Pune needs 1 points from their remaining 5 matches to go to next round. It can be done if they tie any of their 5 matches.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class vaishnavi1 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Read number of test cases
    int T = Integer.parseInt(br.readLine().trim());

    // Iterate through each test case
    for (int t = 0; t < T; t++) {
      // Read P and Q
      String[] input = br.readLine().trim().split(" ");
      int P = Integer.parseInt(input[0]);
      int Q = Integer.parseInt(input[1]);

      // Calculate number of matches Pune needs to win
      int matchesToWin = (P == 1) ? 0 : (P / 2 + (P % 2));

      // Output the result for this test case
      System.out.println(matchesToWin);
    }

    br.close();
  }
}
