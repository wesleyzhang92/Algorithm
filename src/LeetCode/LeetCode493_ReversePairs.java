package LeetCode;

/**
 * Reverse Pairs
 * <p>
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 * <p>
 * You need to return the number of important reverse pairs in the given array.
 * <p>
 * Example1:
 * <p>
 * Input: [1,3,2,3,1]
 * Output: 2
 * Example2:
 * <p>
 * Input: [2,4,3,5,1]
 * Output: 3
 * Note:
 * The length of the given array will not exceed 50,000.
 * All the numbers in the input array are in the range of 32-bit integer.
 * <p>
 * Difficulty: Hard
 */
public class LeetCode493_ReversePairs {
    //如何达到O（logn）的时间复杂度，如何处理相乘溢出的问题进行二倍的比较，注意正负数
    int count = 0;

    public int reversePairs(int[] nums) {
        merge(nums);
        return count;
    }

    public int[] merge(int[] array) {
        if (array.length < 2 || array == null) {
            return array;
        }
        int mid = array.length / 2;
        int[] l = new int[mid];
        int[] r = new int[array.length - mid];
        for (int i = 0; i < mid; i++) {
            l[i] = array[i];
        }
        for (int j = mid; j < array.length; j++) {
            r[j - mid] = array[j];
        }
        merge(l);
        merge(r);
        important(array, l, r);
        return array;
    }

    private void important(int[] array, int[] left, int[] right) {
        int l = 0;
        int r = 0;
        while (l < left.length && r < right.length) {
            if ((long) left[l] > right[r] * 2L) {
                r++;
                count += left.length - l;
            } else {
                l++;
            }
        }
        /*declare i, j for the index of the two subarrays and the target array*/
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}
