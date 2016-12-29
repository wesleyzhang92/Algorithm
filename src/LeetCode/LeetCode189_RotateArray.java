package LeetCode;

/**
 * Rotate Array
 * <p>
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Hint:
 * Could you do it in-place with O(1) extra space?
 * Related problem: Reverse Words in a String II
 * <p>
 * KeyWords: Array
 * Difficulty: Easy
 */
public class LeetCode189_RotateArray {

    //Soution1
    public void rotate(int[] nums, int k) {
        if (nums == null || k < 1)
            return;
        k = k % nums.length;
        int[] a = new int[nums.length];

        for (int i = 0; i < k; i++) {
            a[i] = nums[nums.length - k + i];
        }
        for (int i = k, j = 0; i < nums.length; i++, j++) {
            a[i] = nums[j];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    // Solution 2 Only O(1) space,The basic idea is that, for example, nums = [1,2,3,4,5,6,7] and k = 3,
    // first we reverse [1,2,3,4], it becomes[4,3,2,1]; then we reverse[5,6,7], it becomes[7,6,5],
    // finally we reverse the array as a whole, it becomes[4,3,2,1,7,6,5] ---> [5,6,7,1,2,3,4].
    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
}
