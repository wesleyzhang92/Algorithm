package LeetCode;

import java.util.Arrays;

/**
 * Single Number
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * KeyWords: Hash Table, Bit Manipulation
 * Difficulty: Easy
 */
public class LeetCode136_SingleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i=i+2){
            if(nums[i]!=nums[i+1])
                return nums[i];
        }
        return nums[nums.length-1];
    }

    //Better Solution : Using XOR
    public int singleNumber2(int[] nums) {
        int ans =0;

        int len = nums.length;
        for(int i=0;i!=len;i++)
            ans ^= nums[i];

        return ans;

    }
}
