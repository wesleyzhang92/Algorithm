package LeetCode;

/**
 * Reverse Integer
 * <p>
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p>
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows.
 * How should you handle such cases?
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * Update (2014-11-10):
 * Test cases had been added to test the overflow behavior.
 * <p>
 * KeyWords: Math,Overflow
 * Difficulty: Easy
 */
public class LeetCode007_ReverseInteger {


    public int reverse(int x) {
        int result;
        long a = 0;
        if (x < 0)
            result = -x;
        else
            result = x;
        while (result != 0) {
            a = a * 10 + result % 10;
            result = result / 10;
        }

        if (a > Integer.MAX_VALUE || a < Integer.MIN_VALUE)
            return 0;
        return x < 0 ? -(int) a : (int) a;
    }

    // Better Solution:If overflow exists, the new result will not equal previous one.
    // No flags needed. No hard code like 0xf7777777 needed.
    public int reverse2(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }


    //可以带符号操作
    public int reverse3(int x) {
        long rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
            System.out.println(x);
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }
        return (int) rev;
    }

    public static void main(String[] args) {
        LeetCode007_ReverseInteger lt = new LeetCode007_ReverseInteger();
        int s = lt.reverse3(-321);
        System.out.print(s);

    }
}
