package LeetCode;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Single Number III
 * <p>
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * <p>
 * KeyWords: Bit Manipulation
 * Difficulty: Medium
 */
public class LeetCode260_SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hs.contains(nums[i]))
                hs.remove(nums[i]);
            else
                hs.add(nums[i]);
        }
        Iterator iterator = hs.iterator();
        int[] result = new int[2];
        int i = 0;
        while (iterator.hasNext()) {
            result[i++] = (int) iterator.next();
        }
        return result;
    }

    //Bit Manipulation Solution
    //Once again, we need to use XOR to solve this problem. But this time, we need to do it in two passes:

    //In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find. Note that since the two numbers are distinct, so there must be a set bit (that is, the bit with value '1') in the XOR result. Find
    //out an arbitrary set bit (for example, the rightmost set bit).
    //In the second pass, we divide all numbers into two groups, one with the aforementioned bit set, another with the aforementioned bit unset. Two different numbers we need to find must fall into the two distinct groups. XOR numbers in each group, we can find a number in either group.

    public int[] singleNumber2(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums) {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            } else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}
