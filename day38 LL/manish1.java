/*
Q1
Raju and Shyam are super fans of a hockey team, and they are excitedly watching their favorite team play against another team today. However, Raju is occasionally occupied with making snacks, so he cannot closely follow the game all the time. In those moments, he relies on Shyam to provide Replys about the current scores of the teams

Shyam informs Raju about the scores N times during the match. He provides Replys in two types of replies:

1. A B Raju's favorite team scored A goals, and the other team scored B goals.

2. A B One team scored A goals, and the other team scored B goals, but Shyam does not specify which team scored how many goals.

Raju is seeking your help to determine the score of their favorite hockey team after each of Shyam's replies. Based on Shyami's current reply and all previous information, Raju wants to know whether is possible to confidently determine the number of goals scored by their favorite team at that moment.

Input Format:

The first line of each test case contains a single integer N, representing the number of times Shyam provides Replys.

The followiong N lines describe Shyam's replies in the format described above Output Format:

For each of Shyam's replies, print a single line containing the string "YES" if it is possible to determine the score of Raju's favorite team after this reply, or "NO" if it is impossible

Example:

Input:
6<-N

2 0 1<-Reply 1
1 3 1<-Reply 2
2 2 4<-Reply 3
2 5 6<-Reply 4
2 8 8<-Reply 5
2 9 10<-Reply 6

Output:
NO
YES
YES
NO
YES
NO

explanation :
Reply 1: Raju cannot know who scored the first goal. Because input start with 2, i.e. input=2 0 1

Reply 2: Shyam told Raju that their favourite team has scored 3 goals so far. Because it's start with 1, ie input= 1 3 1

Reply 3: Raju can conclude that his favourite team has scored 4 goals, since it already scored a goals earlier.

Reply 4: the favourite team could have scored 5 or 6 goals, but there is no way to know which option is correct.

Reply 5: since there is a tie, Raju knows that his favourite team has scored 8 goals

Reply 6: again, Raju cannot know if his favourite team has scored 9 or 10 goals.
*/

import java.util.Scanner;

public class manish1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();

    int min = 0;
    int max = 0;
    boolean confi = false;

    for (int i = 0; i < N; i++) {
      int type = scanner.nextInt();
      int a = scanner.nextInt();
      int b = scanner.nextInt();

      if (type == 1) {
        if (a > b) {
          min = a;
          max = a;
        } else {
          min = b;
          max = b;
        }
        confi = true;
      } else {
        if (confi) {
          if (a == min && b > max) {
            max = b;
          } else if (b == min && a > max) {
            max = a;
          } else if (a == max && b < min) {
            min = b;
          } else if (b == max && a < min) {
            min = a;
          } else {
            confi = false;
          }
        } else {
          min = Math.min(a, b);
          max = Math.max(a, b);
        }
      }

      if (min == max) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}
