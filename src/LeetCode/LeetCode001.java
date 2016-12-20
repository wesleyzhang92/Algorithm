package LeetCode;

import java.util.HashMap;

/**
 * Two Sum
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * UPDATE (2016/2/13):
 * The return format had been changed to zero-based indices. Please read the above updated description carefully.
 * <p>
 * 题解：建立HashMap，进行遍历。需要注意的地方：
 * 1.HashMap的key不可以重复，判断两个相乘是否为target
 * 2.减去当前值判断余下部分是否在HashMap中时，判断结果不是当前值本身
 * <p>
 * KeyWords: Array,HashTable,HashMap
 * Difficulty: Easy
 */
public class LeetCode001 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = {0, 0};

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                if (nums[i] * 2 == target) {
                    result[0] = hm.get(nums[i]);
                    result[1] = i;
                    return result;
                } else {
                    continue;
                }
            }
            hm.put(nums[i], i);
        }
        int red;
        for (int i = 0; i < nums.length; i++) {
            red = target - nums[i];

            if (hm.containsKey(red) && hm.get(red) != i) {
                System.out.println(red + " ");
                result[0] = i;
                result[1] = hm.get(red);
                return result;
            }

        }
        return result;
    }


    //最优解法，O(n)时间，一次遍历，不需要先装入再遍历
    public int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }
}
