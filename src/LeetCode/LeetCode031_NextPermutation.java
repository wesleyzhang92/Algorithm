package LeetCode;

import java.util.Arrays;

/**
 * Next Permutation
 * <p>
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place, do not allocate extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * Difficulty: Medium
 * KeyWords: Array
 */
public class LeetCode031_NextPermutation {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        Arrays.sort(nums, i + 1, nums.length);

    }

    public void nextPermutation2(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int i = nums.length - 1;

        for (; i >= 1; i--) {

            if (nums[i] > nums[i - 1]) { //find first number which is smaller than it's after number
                break;
            }
        }

        if (i != 0) {
            swap(nums, i - 1); //if the number exist,which means that the nums not like{5,4,3,2,1}
        }

        reverse(nums, i);
    }

    private void swap(int[] a, int i) {
        for (int j = a.length - 1; j > i; j--) {
            if (a[j] > a[i]) {
                int t = a[j];
                a[j] = a[i];
                a[i] = t;
                break;
            }
        }
    }

    private void reverse(int[] a, int i) {//reverse the number after the number we have found
        int first = i;
        int last = a.length - 1;
        while (first < last) {
            int t = a[first];
            a[first] = a[last];
            a[last] = t;
            first++;
            last--;
        }
    }
}
