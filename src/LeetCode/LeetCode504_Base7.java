package LeetCode;

/**
 * Base 7
 * <p>
 * Given an integer, return its base 7 string representation.
 * <p>
 * Example 1:
 * Input: 100
 * Output: "202"
 * Example 2:
 * Input: -7
 * Output: "-10"
 * Note: The input will be in range of [-1e7, 1e7].
 * <p>
 * Difficulty: Easy
 */
public class LeetCode504_Base7 {
    public String convertTo7(int num) {
        int flag = num < 0 ? -1 : 1;
        num = num < 0 ? -num : num;
        StringBuilder sb = new StringBuilder();
        if (num < 7) {
            sb.append(num + "");
        }
        while (num / 7 >= 1) {
            int res = num / 7;
            int red = num % 7;
            sb.append(red + "");
            num = res;
            if (num < 7) {
                sb.append(num + "");
            }
        }
        String result = sb.reverse().toString();
        if (flag == -1) {
            result = "-" + result;
        }
        return result;
    }
}
