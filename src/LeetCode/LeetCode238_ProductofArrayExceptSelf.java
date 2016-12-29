package LeetCode;

/**
 * Product of Array Except Self
 * <p>
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 * <p>
 * KeyWords: Array
 * Difficulty: Medium
 */
public class LeetCode238_ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int num = 1;
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                num *= nums[i];
            else {
                zeros++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeros > 2)
                nums[i] = 0;
            if (nums[i] == 0 && zeros < 2) {
                nums[i] = num;
            } else if (nums[i] != 0 && zeros == 0) {
                nums[i] = num / nums[i];
            } else {
                nums[i] = 0;
            }
        }
        return nums;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
