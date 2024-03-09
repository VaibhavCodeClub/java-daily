// write a function which takes in an array of strings and returns the array with each string reversed

import java.util.Arrays;

public class four {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(revStr(new String[] { "abba", "abc", "vaibhav", "xyz" })));
    }

    private static String[] revStr(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            strings[i] = rev(strings[i]);
        }
        return strings;
    }

    private static String rev(String string) {
        String ret = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            ret += string.charAt(i);
        }
        return ret;
    }
}
