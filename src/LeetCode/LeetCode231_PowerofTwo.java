package LeetCode;

/**
 * Power of Two
 * <p>
 * Given an integer, write a function to determine if it is a power of two.
 * <p>
 * KeyWords: Math, Bit Manipulation
 * Difficulty: Easy
 */
public class LeetCode231_PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        return n <= 0 ? false : (n & (n - 1)) == 0;
    }


    // Power of Two has only one 1 in it's binary represent
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
}
