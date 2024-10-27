/*
In java While traveling, you come across an Enchanted Forest, inhabited mainly by three types of magical creatures: Goblins, Elf, and Fairy. Each magical creature is identified by a unique number: Goblins are represented by 1, Elf by 2, and Fairy by 3.

There are also other creatures with different unique values apart from 1, 2, and 3.

As you journey through the forest, you encounter various magical creatures, each with its own set of interactions.
If you encounter an elf, the elf will give you 5 coins.
If you come across a fairy, the fairy will double your current number of coins.

However, if you stumble upon a goblin, it will steal 2/3 of the coins(rounded down to the nearest integer).

If you encounter with any other creature, you must give one coin to it.

Let's suppose you start your journey with N coins.

Write a code calculates the total amount of coins you'll have left after crossing the forest.

Input format:

The 1st line contains the value of N (initial coins).

The 2nd line contains space-separated inputs containing the unique value of magical creatures that you encountered Example:

Input

4
1 4 8 5 2 3

Output:
7
Explanation:
initial coins: 4
creatures encountered: 1 4 8 5 2 3
first creature encountered: 1 means Goblins, Goblins will steal 2/3 of yours coins. coins stolen by goblins = 4*2/3=2.66 -> 2 (rounded down to the nearest integer) your total coins= 4-2=2

next creature encountered: 4, means it is some other creature, so you will give one coin. your total coins = 2-1=1

next creature encountered: 8, means it is some other creature, so you will give one coin. your total coins=1-1=0

next creature encountered: 5, means it is some other creature, so you will give one coin But you don't have any coins to give, so you will walk by

next creature encountered: 2, means Elf, Elf will give you 5 coins. your total coins=0+5=5

last creature encountered: 3, means Fairy, fairy will double your coins.
your total coins = 5*2 = 10

Total coins left after crossing the Enchanted Forest: 10
*/
import java.util.Scanner;

public class manish2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int coins = scanner.nextInt();

    scanner.nextLine();
    String[] creatures = scanner.nextLine().split(" ");

    for (String creature : creatures) {
      int creature = Integer.parseInt(creature);

      if (creature == 1) {
        coins = coins - ((coins * 2) / 3);
      } else if (creature == 2) {
        coins += 5;
      } else if (creature == 3) {
        coins *= 2;
      } else {
        if (coins > 0) {
          coins -= 1;
        }
      }
    }
    System.out.println(coins);
    scanner.close();
  }
}
