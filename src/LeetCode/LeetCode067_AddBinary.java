package LeetCode;

/**
 * Add Binary
 *
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 *
 * KeyWords: Math, String
 * Difficulty: Easy
 */
public class LeetCode067_AddBinary {
    public String addBinary(String a, String b) {
        String sum = "";
        int carray = 0;

        if(a.length() > b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        //使a和b的长度相等
        int gap = b.length() - a.length();
        while((gap--) != 0) a = "0" + a;

        for (int i = b.length() - 1; i >= 0; i--) {
            int n = a.charAt(i) - '0' + b.charAt(i) - '0' + carray;
            sum = (n % 2) + sum;
            carray = n / 2;
        }

        if(carray != 0) sum = carray % 2 + sum;
        return sum;
    }
}
