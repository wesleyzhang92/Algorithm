package LeetCode;

/**
 * First Unique Character in a String
 * <p>
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * Examples:
 * s = "leetcode"
 * return 0.
 * s = "loveleetcode",
 * return 2.
 * <p>
 * Difficulty: Easy
 */
public class LeetCode387_FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        int[] numbers = new int[26];
        for (int i = 0; i < s.length(); i++) {
            numbers[s.charAt(i) - 'a']++;
        }
        int result = -1;
        for (int i = 0; i < s.length(); i++) {
            if (numbers[s.charAt(i) - 'a'] == 1) {
                result = i;
                break;
            }
        }
        return result;
    }

    public int firstUniqChar2(String s) {

        char[] a = s.toCharArray();

        for (int i = 0; i < a.length; i++) {
            if (s.indexOf(a[i]) == s.lastIndexOf(a[i])) {
                return i;
            }
        }
        return -1;
    }
}
