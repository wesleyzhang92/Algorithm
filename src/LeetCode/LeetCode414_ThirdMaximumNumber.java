package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Third Maximum Number
 * <p>
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 * <p>
 * Example 1:
 * Input: [3, 2, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * <p>
 * Output: 2
 * <p>
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 * <p>
 * KeyWords: Array
 * Difficulty: Easy
 */
public class LeetCode414_ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        if (nums.length < 3) {
            Arrays.sort(nums);
            return nums[nums.length - 1];
        }
        long[] result = new long[3];
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            result[i] = Long.MIN_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > result[0] && !hs.contains(nums[i])) {
                hs.add(nums[i]);
                result[0] = nums[i];
                Arrays.sort(result);
            }
        }

        int ret = result[0] == Long.MIN_VALUE ? (int) Math.max(result[1], result[2]) : (int) result[0];
        return ret;
    }


    //PriorityQueue
    public int thirdMax2(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                pq.offer(i);
                set.add(i);
                if (pq.size() > 3) {
                    set.remove(pq.poll());
                }
            }
        }
        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
        }
        return pq.peek();
    }

}
