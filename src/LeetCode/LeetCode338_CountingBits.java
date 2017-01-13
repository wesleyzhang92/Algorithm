package LeetCode;

/**
 * Counting Bits
 * <p>
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * Follow up:
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 * Hint:
 * You should make use of what you have produced already.
 * Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
 * Or does the odd/even status of the number help you in calculating the number of 1s?
 * <p>
 * KeyWords: Dynamic Programming, Bit Manipulation
 * Difficulty: Medium
 */
public class LeetCode338_CountingBits {

    //Concise Solution
    public int[] countBits2(int num) {
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }

    //Solution 2
    public int[] countBits3(int num) {
        int[] ret = new int[num + 1];
        ret[0] = 0;
        int pow = 1;
        for (int i = 1, t = 0; i <= num; i++, t++) {
            if (i == pow) {
                pow *= 2;
                t = 0;
            }
            ret[i] = ret[t] + 1;
        }
        return ret;
    }

    //My Solution
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i < num + 1; i++) {
            result[i] = bitCount(i);
        }

        return result;
    }

    public static int bitCount(int n) {
        int c = 0;
        while (n > 0) {
            if ((n & 1) == 1)
                c++;
            n >>= 1;
        }
        return c;
    }
}
