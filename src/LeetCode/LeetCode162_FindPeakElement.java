package LeetCode;

/**
 * Find Peak Element
 * <p>
 * A peak element is an element that is greater than its neighbors.
 * <p>
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * <p>
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * <p>
 * You may imagine that num[-1] = num[n] = -∞.
 * <p>
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * <p>
 * KeyWords: Binary Search, Array
 * Difficulty: Medium
 */
public class LeetCode162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < nums[mid - 1]) {
                end = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] > nums[end]) {
            return start;
        } else {
            return end;
        }
    }

    public int findPeakElement2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;

    }
}
