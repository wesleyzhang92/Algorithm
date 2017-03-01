package LeetCode;

import java.util.*;

/**
 * 3 Sum
 * <p>
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * Difficulty: Medium
 * KeyWords: Array, Two Pointers
 */
public class LeetCode015_3Sum {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }


    //In my way
    public List<List<Integer>> threeSum2(int[] num) {
        Arrays.sort(num);
        HashSet<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < num.length - 2; i++) {
            int sum = 0 - num[i];
            int j = i + 1, k = num.length - 1;
            while (j < k) {
                if (num[j] + num[k] == sum) {
                    if (!res.contains(Arrays.asList(num[i], num[j], num[k]))) {
                        res.add(Arrays.asList(num[i], num[j], num[k]));
                    }
                    j++;
                    k--;
                }
                if (num[j] + num[k] > sum) k--;
                if (num[j] + num[k] < sum) j++;
            }
        }
        return new ArrayList<List<Integer>>(res);
    }
}
