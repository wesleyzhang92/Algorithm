package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Intersection of Two Arrays
 * <p>
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 * <p>
 * KeyWords: Binary Search, Hash Table, Two Pointer, Sort
 * Difficulty: Easy
 */
public class LeetCode349_IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<Integer>();
        HashSet<Integer> hs2 = new HashSet<Integer>();
        int size = nums1.length > nums2.length ? nums2.length : nums1.length;
        int i, count = 0;

        for (i = 0; i < nums1.length; i++) {
            hs.add(nums1[i]);
        }
        for (i = 0; i < nums2.length; i++) {
            if (hs.contains(nums2[i])) {
                hs2.add(nums2[i]);
            }
        }
        int[] result = new int[hs2.size()];
        for (Iterator it = hs2.iterator(); it.hasNext(); ) {
            result[count] = (int) it.next();
            count++;
        }
        return result;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }

    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
