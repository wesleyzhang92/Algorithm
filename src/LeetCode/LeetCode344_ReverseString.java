package LeetCode;

/**
 * Reverse String
 * <p>
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 * <p>
 * KeyWords: Two Pointers, String
 * Difficulty: Easy
 */
public class LeetCode344_ReverseString {
    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }

    //利用StringBuilder函数
    public String reverseString2(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
