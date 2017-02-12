package LeetCode;

/**
 * Remove Duplicates from Sorted Array II
 * <p>
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 * <p>
 * KeyWords: Array, Two Pointers
 * Difficulty: Medium
 */
public class LeetCode080_RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = 0, count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[size]) {
                nums[++size] = nums[i];
                count = 1;
            } else if (i != size && count < 2) {
                nums[++size] = nums[i];
                count++;
            }
        }

        return size + 1;
    }


    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }
}
