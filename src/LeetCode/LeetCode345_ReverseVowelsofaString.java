package LeetCode;

import java.util.HashSet;
import java.util.Stack;

/**
 * Reverse Vowels of a String
 * <p>
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Example 1:
 * Given s = "hello", return "holle".
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * Note:
 * The vowels does not include the letter "y".
 * <p>
 * KeyWords: Two Pointers, String
 * Difficulty: Easy
 */
public class LeetCode345_ReverseVowelsofaString {
    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        HashSet<Character> hs = new HashSet<Character>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        hs.add('A');
        hs.add('E');
        hs.add('I');
        hs.add('O');
        hs.add('U');
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < cs.length; i++) {
            if (hs.contains(cs[i])) {
                System.out.println(cs[i]);
                st.push(cs[i]);
            }
        }
        for (int i = 0; i < cs.length; i++) {
            if (hs.contains(cs[i]))
                cs[i] = st.pop();
        }

        return String.valueOf(cs);
    }

    public String reverseVowels2(String s) {
        if (s == null || s.length() == 0) return s;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {

            while (start < end && !vowels.contains(chars[start] + "")) {
                start++;
            }

            while (start < end && !vowels.contains(chars[end] + "")) {
                end--;
            }

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return new String(chars);
    }
}
