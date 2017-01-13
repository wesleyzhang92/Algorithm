package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Ransom Note
 * <p>
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * <p>
 * KeyWords: String
 * Difficulty: Easy
 */
public class LeetCode383_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if (!hm.containsKey(magazine.charAt(i)))
                hm.put(magazine.charAt(i), 1);
            else
                hm.replace(magazine.charAt(i), hm.get(magazine.charAt(i)), hm.get(magazine.charAt(i)) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!hm.containsKey(ransomNote.charAt(i)) || hm.get(ransomNote.charAt(i)) < 1)
                return false;
            else
                hm.replace(ransomNote.charAt(i), hm.get(ransomNote.charAt(i)), hm.get(ransomNote.charAt(i)) - 1);
        }
        return true;
    }

    //不利用HashMap的做法
    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
