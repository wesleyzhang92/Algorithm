package LeetCode;

/**
 * Search Insert Position
 * <p>
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * <p>
 * KeyWords: Array, Binary Search
 * Difficulty: Medium
 */
public class LeetCode035_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1, pos = 0, mid;
        while (l <= r) {
            mid = (l + r) >> 1;
            if (target == nums[mid]) return mid;
            else if (target > nums[mid]) {
                l = mid + 1;
                pos = mid + 1;
            } else {
                r = mid - 1;
                pos = mid;
            }
        }
        return pos;
    }

    public int searchInsert2(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) return mid;
            else if (A[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
