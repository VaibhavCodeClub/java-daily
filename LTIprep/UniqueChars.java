import java.util.*;

public class UniqueChars {

    public static void main(String[] args) {
        String s = "visya";
        // HashMap
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        boolean unique = true;
        for (char ch : map.keySet()) {
            if (map.get(ch) > 1) {
                unique = false;
                break;
            }
        }

        if (unique) System.out.println("unique");
        else System.out.println("not unique");

        // HashSet
        // vaishnavi
        // vaishn
        HashSet<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }
        if (set.size() == s.length()) {
            System.out.println("unique");
        } else {
            System.out.println("not unique");
        }
    }
}
