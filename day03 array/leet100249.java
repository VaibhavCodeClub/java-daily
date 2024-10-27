public class leet100249 {
    public static void main(String[] args) {

    }

    public static String minimizeStringValue(String s) {

        char[] charArray = s.toCharArray();
        int[] count = new int[26];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '?') {
                for (int j = 0; j < 26; j++) {
                    if (j != charArray[i] - 'a') {
                        count[j]++;
                    }
                }
            }
        }

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '?') {
                char smallestChar = 'a';
                int minCost = Integer.MAX_VALUE;

                for (int j = 0; j < 26; j++) {
                    int cost = count[j];
                    if (cost < minCost) {
                        smallestChar = (char) ('a' + j);
                        minCost = cost;
                    }
                }

                result.append(smallestChar);

                for (int j = 0; j < 26; j++) {
                    if (j != smallestChar - 'a') {
                        count[j]++;
                    }
                }
            } else {
                result.append(charArray[i]);
            }
        }

        return result.toString();
    }
}
