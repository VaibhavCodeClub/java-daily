// Find Words Containing Character
// You are given a 0-indexed array of strings words and a character x.

// Return an array of indices representing the words th at contain the character x.

// Note that the returned array may be in any order.

import java.util.ArrayList;
import java.util.List;

public class leet2942{
    public static void main(String args[]){
        System.out.println(findWordsContaining(new String[]{"abc","bcd","aaaa","cbc"},'a'));
        System.out.println(findWordsContaining0(new String[]{"abc","bcd","aaaa","cbc"},'a'));
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ret=new ArrayList<>();
        for(int i = 0; i < words.length ; i++){
            if(words[i].contains(String.valueOf(x)))
                ret.add(i);
        }
        return ret;
    }
        public static List<Integer> findWordsContaining0(String[] words, char x) {
        List<Integer> lRet = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1)
                lRet.add(i);
        }

        return lRet;
}
}