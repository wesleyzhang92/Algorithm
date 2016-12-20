package LeetCode;

import java.util.HashMap;

/**
 * Single Number II
 *
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * KeyWords: Bit Manipulation
 * Difficulty: Medium
 */
public class LeetCode137 {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                if(hm.get(nums[i])==2)
                    hm.remove(nums[i]);
                else
                    hm.put(nums[i],(hm.get(nums[i])+1));
            }
            else
                hm.put(nums[i],1);
        }
        if(!hm.isEmpty()){
            for(int key : hm.keySet())
                return key;
        }

        return 0;
    }


    //Better Solution
    public int singleNumber2(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }
}
