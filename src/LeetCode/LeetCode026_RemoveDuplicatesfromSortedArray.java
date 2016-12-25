package LeetCode;

/**
 * Remove Duplicates from Sorted Array
 * <p>
 * Given a sorted array[有序], remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 * <p>
 * KeyWords: Array,Two pointer
 * Difficulty: Easy
 */
public class LeetCode026_RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums)
            if (n > nums[i - 1])
                nums[i++] = n;
        return i;
    }


    //Another Solution
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) return 1;
        int diff = 0, left = 0;
        for (int i = 0; i < nums.length; ) {
            left = nums[i];
            while (i < nums.length && left == nums[i]) {
                i++;
            }
            nums[diff++] = left;
        }

        return diff;
    }
}
