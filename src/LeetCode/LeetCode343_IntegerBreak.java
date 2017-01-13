package LeetCode;

/**
 * Integer Break
 * <p>
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * Note: You may assume that n is not less than 2 and not larger than 58.
 * Hint:
 * There is a simple O(n) solution to this problem.
 * You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
 * <p>
 * KeyWords: Dynamic Programming, Math
 * Difficulty: Medium
 */
public class LeetCode343_IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        product *= n;

        return product;
    }


    //Java DP Solution
    public int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], (Math.max(j, dp[j])) * (Math.max(i - j, dp[i - j])));
            }
        }
        return dp[n];
    }
}
