// Length of Last Word
// Given a string s consisting of words and spaces, return the length of the last word in the string.

// A word is a maximal substring consisting of non-space characters only.

public class leet58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord0("   fly me   to   the moon  "));
    }

    public static int lengthOfLastWord(String s) {
        int finalLength = 0, currentLength = 0;
        for (char cha : s.toCharArray()) {
            if (cha == ' ') {
                if (currentLength > 0) {
                    finalLength = currentLength;
                    currentLength = 0;
                }
            } else {
                currentLength++;
            }
            if (currentLength > 0)
                finalLength = currentLength;
        }
        return finalLength;
    }public static int lengthOfLastWord0(String s) {
        String[] strArr = s.split(" ");
        String ans = strArr[strArr.length - 1];

        return ans.length();
    }

}