package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Majority Element
 * <p>
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * KeyWords: Array, Divide and Conquer, Bit manipulation
 * Difficulty: Easy
 */
public class LeetCode169_MajorityElement {

    // Sorting
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // Hashtable
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        //Hashtable<Integer, Integer> myMap = new Hashtable<Integer, Integer>();
        int ret = 0;
        for (int num : nums) {
            if (!myMap.containsKey(num))
                myMap.put(num, 1);
            else
                myMap.put(num, myMap.get(num) + 1);
            if (myMap.get(num) > nums.length / 2) {
                ret = num;
                break;
            }
        }
        return ret;
    }

    // Moore voting algorithm  O(1)空间和O(n)时间
    // 在遍历过程中，当前元素与candidate相同则投支持票，否则投反对票。当count状态为0时，说明之前的子数组中不存在重复次数超过一半
    // 的数，遍历余下的数组成为原问题的子问题。若该数不一定存在，那么需要再一次遍历数组，鉴证找到的元素是否符合条件。
    public int majorityElement3(int[] nums) {
        int count = 0, ret = 0;
        for (int num : nums) {
            if (count == 0)
                ret = num;
            if (num != ret)
                count--;
            else
                count++;
        }
        return ret;
    }

    // Bit manipulation
    public int majorityElement(int[] nums) {
        int[] bit = new int[32];
        for (int num : nums)
            for (int i = 0; i < 32; i++)
                if ((num >> (31 - i) & 1) == 1)
                    bit[i]++;
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            bit[i] = bit[i] > nums.length / 2 ? 1 : 0;
            ret += bit[i] * (1 << (31 - i));
        }
        return ret;
    }
}
