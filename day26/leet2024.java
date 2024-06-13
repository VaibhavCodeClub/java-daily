// Maximize the Confusion of an Exam

/*
A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false. He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).

You are given a string answerKey, where answerKey[i] is the original answer to the ith question. In addition, you are given an integer k, the maximum number of times you may perform the following operation:

    Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').

Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.
*/

public class leet2024 {
    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("TTFTTFTT", 1));
        System.out.println(maxConsecutiveAnswers0("TTFTTFTT", 1));
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int left = 0, length = answerKey.length(), answer = 0, counter = 0;

        for (int i = 0; i < length; i++) {
            if (answerKey.charAt(i) == 'F') {
                counter++;
            }
            while (counter > k) {
                if (answerKey.charAt(left) == 'F') {
                    counter--;
                }
                left++;
            }
            answer = Math.max(answer, i - left + 1);
        }
        left = 0;
        counter = 0;
        for (int i = 0; i < length; i++) {
            if (answerKey.charAt(i) == 'T') {
                counter++;
            }
            while (counter > k) {
                if (answerKey.charAt(left) == 'T') {
                    counter--;
                }
                left++;
            }
            answer = Math.max(answer, i - left + 1);
        }
        return answer;
    }

    public static int maxConsecutiveAnswers0(String answerKey, int k) {
        char[] str = answerKey.toCharArray();
        int result = 0, max = 0;

        char[] ch = new char[20];
        
        for (int i = 0; i < str.length; i++) {
            max = Math.max(max, ++ch[str[i] - 'A']);
            if (result - max < k) {
                result++;
            } else {
                ch[str[i - result] - 'A']--;
            }
        }
        return result;
    }

}
