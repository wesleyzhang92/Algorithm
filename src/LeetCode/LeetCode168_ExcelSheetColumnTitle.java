package LeetCode;

/**
 * Excel Sheet Column Title
 * <p>
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * <p>
 * KeyWords: Math
 * Difficulty: Easy
 */
public class LeetCode168_ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        String result = "";
        int tmp = n;
        while (tmp > 26) {
            int digit = (tmp - 1) % 26;
            result = (char) (digit + 65) + result;
            tmp = (tmp - 1) / 26;
        }
        //tmp <= 26
        result = (char) (tmp + 64) + result;
        return result;
    }

    //One line Solution
    public String convertToTitle2(int n) {
        return n == 0 ? "" : convertToTitle2(--n / 26) + (char) ('A' + (n % 26));
    }

    //String Builder Version
    public String convertToTitle3(int n) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            n--;
            result.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
}
