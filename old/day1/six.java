// writ a for loop that prints the odd numbers in between 1 and 10

public class six {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            if (i == 1)
                continue;
            if (i % 2 == 0)
                continue;
            System.out.println(i);
        }
    }
}
