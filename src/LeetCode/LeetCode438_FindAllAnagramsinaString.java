package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Find All Anagrams in a String
 * <p>
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * <p>
 * KeyWords: HashTable
 * Difficulty: Easy
 */
public class LeetCode438_FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p == null || s == null || s.length() < p.length()) return res;
        int m = s.length(), n = p.length();
        for (int i = 0; i < m - n + 1; i++) {
            String cur = s.substring(i, i + n);
            if (helper(cur, p)) res.add(i);
        }
        return res;
    }

    public boolean helper(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) return false;
        int[] dict = new int[26];
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            dict[ch - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            char ch = b.charAt(i);
            dict[ch - 'a']--;
            if (dict[ch - 'a'] < 0) return false;
        }
        return true;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        int[] chars = new int[26];
        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length())
            return result;
        for (char c : p.toCharArray())
            chars[c - 'a']++;

        int start = 0, end = 0, count = p.length();
        // Go over the string
        while (end < s.length()) {
            // If the char at start appeared in p, we increase count
            if (end - start == p.length() && chars[s.charAt(start++) - 'a']++ >= 0)
                count++;
            // If the char at end appeared in p (since it's not -1 after decreasing), we decrease count
            if (--chars[s.charAt(end++) - 'a'] >= 0)
                count--;
            if (count == 0)
                result.add(start);
        }

        return result;
    }
}
