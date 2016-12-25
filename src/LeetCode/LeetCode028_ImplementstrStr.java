package LeetCode;

/**
 * Implement strStr().
 * <p>
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * KeyWords: String,Two pointer
 * Difficulty:Easy
 */
public class LeetCode028_ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length())
            return -1;
        int l1 = haystack.length();
        int l2 = needle.length();
        for (int i = 0, j; i <= l1 - l2; ++i) {
            for (j = 0; j < l2 && haystack.charAt(i + j) == needle.charAt(j); ++j) ;
            if (j == l2)
                return i;
        }
        return -1;
    }

    //Elegant Solution
    public int strStr2(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
