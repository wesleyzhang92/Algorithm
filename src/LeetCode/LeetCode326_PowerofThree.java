package LeetCode;

/**
 * Power of Three
 * <p>
 * Given an integer, write a function to determine if it is a power of three.
 * Follow up:
 * Could you do it without using any loop / recursion?
 * <p>
 * KeyWords: Math
 * Difficulty: Easy
 */
public class LeetCode326_PowerofThree {
    public boolean isPowerOfThree(int n) {
        if (n > 1)
            while (n % 3 == 0) n /= 3;
        return n == 1;
    }

    //maxPowerOfThree = 1162261467
    public boolean isPowerOfThree2(int n) {
        return n > 0 && (1162261467 % n == 0);
    }

    //If log10(n) / log10(3) returns an int (more precisely, a double but has 0 after decimal point), then n is a power of 3
    //不能直接使用log，log(243) = 5.493061443340548    log(3) = 1.0986122886681098==> log(243)/log(3) = 4.999999999999999 出错
    public boolean isPowerOfThree3(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
