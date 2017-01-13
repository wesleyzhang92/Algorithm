package LeetCode;

import java.util.HashSet;

/**
 * Longest Palindrome
 * <p>
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * <p>
 * Example:
 * <p>
 * Input:
 * "abccccdd"
 * <p>
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * KeyWords: HashTable
 * Difficulty: Easy
 */
public class LeetCode409_LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> hs = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                hs.remove(s.charAt(i));
                count++;
            } else {
                hs.add(s.charAt(i));
            }
        }
        if (!hs.isEmpty()) return count * 2 + 1;
        return count * 2;
    }

    public static void main(String[] args) {
        LeetCode409_LongestPalindrome lt = new LeetCode409_LongestPalindrome();
        int res = lt.longestPalindrome("abccccdd");
    }

    public int longestPalindrome2(String s) {
        int[] lowercase = new int[26];
        int[] uppercase = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp >= 97) lowercase[temp - 'a']++;
            else uppercase[temp - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            res += (lowercase[i] / 2) * 2;
            res += (uppercase[i] / 2) * 2;
        }
        return res == s.length() ? res : res + 1;

    }
}
