package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Contiguous Array
 * <p>
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * <p>
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * <p>
 * Difficulty: Medium
 */
public class LeetCode525_ContiguousArray {
    //思想：change 0 in the original array to -1. Thus, if we find SUM[i, j] == 0 then we know there are even number
    // of -1 and 1 between index i and j. Also put the sum to index mapping to a HashMap to make search faster.
    // sumToIndex.containsKey(sum) HashMap中存放的是某一个数第一次出现的位置，当这个和再次出现，意味着他们之间的部分1和0的数目是相等的
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : nums[i];
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }

        return max;
    }
}
