package LeetCode;

/**
 * Number of 1 Bits
 * <p>
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * <p>
 * KeyWords: Bit Manipulation
 * Difficulty: Easy
 */
public class LeetCode191_Numberof1Bits {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
