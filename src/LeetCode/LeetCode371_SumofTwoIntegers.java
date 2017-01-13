package LeetCode;

/**
 * Sum of Two Integers
 * <p>
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * Example:
 * Given a = 1 and b = 2, return 3.
 * <p>
 * KeyWords: Bit Manipulation
 * Difficulty: Easy
 */
public class LeetCode371_SumofTwoIntegers {
    public int getSum(int a, int b) {
        int result = a ^ b; // 按位加
        int carray = (a & b) << 1; // 计算进位
        if (carray != 0) return getSum(result, carray); //判断进位与处理
        return result;
    }

    // Recursive
    public int getSum2(int a, int b) {
        return (b == 0) ? a : getSum2(a ^ b, (a & b) << 1);
    }
}
