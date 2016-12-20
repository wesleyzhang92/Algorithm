package LeetCode;

/**
 * Length of Last Word
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example,
 * Given s = "Hello World",
 * return 5.
 * KeyWords: String
 * Difficulty: Easy
 */
public class LeetCode058 {
    public int lengthOfLastWord(String s) {
        String[] aa = s.split(" ");
        if(aa.length==0)
            return 0;
        else
            return aa[aa.length-1].length();
    }

    //Another Solution---Common Way
    public int lengthOfLastWord2(String s) {
        int sLen = s.length();
        int lengthOfLastWordCount = 0;
        while (s.charAt(sLen - 1) == ' ')
            sLen--;
        for (int i = sLen - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            lengthOfLastWordCount++;
        }
        return lengthOfLastWordCount;
    }
}
