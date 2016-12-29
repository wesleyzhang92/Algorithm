package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Isomorphic Strings
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * Note:
 * You may assume both s and t have the same length.
 * <p>
 * KeyWords: HashTable
 * Difficulty: Easy
 */
public class LeetCode205_IsomorphicStrings {

    //注意HashMap的使用，包含了ContainsKey和ContainsValue，配合Set是多此一举
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<Character, Character>();
        //Set<Character> set = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) return false;
            } else {
                if (map.containsValue(c2)) return false;
                else {
                    map.put(c1, c2);
                    //set.add(c2);
                }
            }
        }
        return true;
    }

    // Without Map Solution
    // The main idea is to store the last seen positions of current (i-th) characters in both strings. If previously stored
    // positions are different then we know that the fact they're occuring in the current i-th position simultaneously is a
    // mistake. We could use a map for storing but as we deal with chars which are basically ints and can be used as indices
    // we can do the whole thing with an array.
    public boolean isIsomorphic2(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i) + 256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i) + 256] = i + 1;
        }
        return true;
    }
}
