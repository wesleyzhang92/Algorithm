package LeetCode;

import java.util.HashMap;

/**
 * Word Pattern
 * <p>
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * <p>
 * KeyWords: HashTable
 * Difficulty: Easy
 */
public class LeetCode290_WordPattern {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> hm = new HashMap<Character, String>();
        String[] strArray = str.split(" ");
        if (strArray.length != pattern.length())
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (hm.containsKey(pattern.charAt(i))) {
                if (!strArray[i].equals(hm.get(pattern.charAt(i)))) {
                    return false;
                }
            } else {
                if (hm.containsValue(strArray[i]))
                    return false;
                hm.put(pattern.charAt(i), strArray[i]);
            }
        }

        return true;
    }
}
