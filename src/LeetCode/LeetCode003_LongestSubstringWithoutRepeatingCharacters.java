package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Difficulty: Medium
 * KeyWords: Two Pointer, String , Hash Table
 */
public class LeetCode003_LongestSubstringWithoutRepeatingCharacters {
    // 循环会超时
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0)
            return 0;
        int max = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            i = j;
            int count = 0;
            HashSet<Character> hs = new HashSet<>();
            while (i < s.length() && !hs.contains(s.charAt(i))) {
                hs.add(s.charAt(i++));
                count++;
            }
            max = count > max ? count : max;
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }


    // The idea is use a hashset to track the longest substring without repeating characters so far, use a fast pointer
    // j to see if character j is in the hash set or not, if not, great, add it to the hash set, move j forward and update
    // the max length, otherwise, delete from the head by using a slow pointer i until we can put character j to the hash set.
    public int lengthOfLongestSubstring3(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}
