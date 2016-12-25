package LeetCode;

/**
 * Excel Sheet Column Number
 * <p>
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * <p>
 * KeyWords: Math
 * Difficulty: Easy
 */
public class LeetCode171_ExcelSheetColumnNumber {
    public static int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i) - 'A' + 1;
            result = result * 26 + tmp;
        }
        return result;
    }
}
