package LeetCode;

/**
 * Maximum Subarray
 * <p>
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * <p>
 * click to show more practice.
 * <p>
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * <p>
 * KeyWords: Array, Dynamic Programming, Divide and Conquer
 */
public class LeetCode053_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int count = nums[0];
        for (int i = 1; i < nums.length; i++) {
            count = Math.max(count + nums[i], nums[i]);
            max = Math.max(max, count);
        }
        return max;
    }

    public int maxSubArray2(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
