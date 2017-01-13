package LeetCode;

/**
 * Number of Segments in a String
 * <p>
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * <p>
 * Please note that the string does not contain any non-printable characters.
 * <p>
 * Example:
 * <p>
 * Input: "Hello, my name is John"
 * Output: 5
 * <p>
 * KeyWords: String
 * Difficulty: Easy
 */
public class LeetCode434_NumberofSegmentsinaString {

    public int countSegments(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' '))
                res++;
        return res;
    }

    public int countSegments2(String s) {
        String trimmed = s.trim();
        if (trimmed.length() == 0) return 0;
        else return trimmed.split("\\s+").length;
    }
}
