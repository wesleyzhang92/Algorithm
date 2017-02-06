package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Contains Duplicate III
 * <p>
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
 * difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 * <p>
 * KeyWords: Binary Search Tree, Bucket, OverFlow
 * Difficulty: Medium
 */
public class LeetCode220_ContainsDuplicateIII {

    // The idea is like the bucket IntroductiontoAlgorithm.sort algorithm. Suppose we have consecutive buckets covering the range of nums with each
    // bucket a width of (t+1). If there are two item with difference <= t, one of the two will happen:
    // (1) the two in the same bucket
    // (2) the two in neighbor buckets
    private long getID(long i, long w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            if (d.containsKey(m))
                return true;
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            d.put(m, (long) nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }

    //O(Nlog(k)) Solution
    public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Integer floor = values.floor(nums[ind] + t);
            final Integer ceil = values.ceiling(nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }

        return false;
    }

    //Time Limit Exceeded
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j <= k && i + j < nums.length; j++) {
                if (getResult(nums[i + j], nums[i]) <= (long) t)
                    return true;
            }
        }
        return false;
    }

    public long getResult(int a, int b) {
        long result = a >= b ? ((long) a - (long) b) : ((long) b - (long) a);
        if (result > Integer.MAX_VALUE)
            return Long.MAX_VALUE;
        if (result < Integer.MIN_VALUE)
            return Long.MIN_VALUE;
        return result;
    }

    public static void main(String[] args) {
        LeetCode220_ContainsDuplicateIII solution = new LeetCode220_ContainsDuplicateIII();
        int[] nums = {-1, 2147483647};
        boolean res = solution.containsNearbyAlmostDuplicate(nums, 1, 2147483647);
        System.out.print(res);
    }
}
