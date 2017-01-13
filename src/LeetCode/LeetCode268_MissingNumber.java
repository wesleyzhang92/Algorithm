package LeetCode;

/**
 * Missing Number
 * <p>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * <p>
 * KeyWords: Array, Math, Bit Manipulation
 * Difficulty: Medium
 */
public class LeetCode268_MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int tmp = 0;
        for (int n : nums) {
            sum += n;
        }
        for (int i = 1; i <= nums.length; i++) {
            tmp += i;
        }
        return tmp - sum;
    }

    // Bit Manipulation Solution
    //The basic idea is to use XOR operation. We all know that a^b^b =a, which means two xor operations with the same number will eliminate the number and reveal the original number.
    //In this solution, I apply XOR operation to both the index and value of the array. In a complete array with no missing numbers, the index and value should be perfectly corresponding( nums[index] = index), so in a missing array, what left finally is the missing number.
    public int missingNumber2(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }
}
