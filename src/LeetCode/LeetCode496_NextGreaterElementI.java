package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Next Greater Element I
 * <p>
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 * <p>
 * Difficulty: Easy
 * KeyWords: Stack
 */
public class LeetCode496_NextGreaterElementI {

    public int[] nextGreaterElement2(int[] findNums, int[] nums) {

        //利用栈找出完整数组中每个元素的下一个更大的值，保存到HashMap中，再遍历findNums找到结果
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }


    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] results = new int[findNums.length];
        for (int j = 0; j < findNums.length; j++) {
            boolean findBigger = false;
            boolean isRight = false;

            for (int i = 0; i < nums.length; i++) {

                if (nums[i] == findNums[j]) {
                    isRight = true;
                }

                if (isRight && findNums[j] < nums[i]) {
                    results[j] = nums[i];
                    findBigger = true;
                    break;
                }
            }

            if (!findBigger) {
                results[j] = -1;
            }
        }
        return results;
    }
}
