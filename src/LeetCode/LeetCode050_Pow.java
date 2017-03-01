package LeetCode;

/**
 * Pow(x, n)
 * <p>
 * implement Pow(x, n)
 * <p>
 * KeyWords: Binary Search, Math
 * Difficulty: Medium
 */
public class LeetCode050_Pow {
    public double power(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        double pow = power(x, n / 2);
        if (n % 2 == 0)
            return pow * pow;
        else
            return x * pow * pow;
    }

    public double myPow(double x, int n) {
        if (n < 0)
            return 1 / power(x, n * -1);
        return power(x, n);
    }
}
