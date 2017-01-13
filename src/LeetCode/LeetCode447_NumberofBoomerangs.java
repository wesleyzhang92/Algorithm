package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Number of Boomerangs
 * <p>
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * <p>
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 * <p>
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 * <p>
 * KeyWords: HashTable
 * Difficulty: Easy
 */
public class LeetCode447_NumberofBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;

                int d = getDistance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }

            for (int val : map.values()) {
                res += val * (val - 1);
            }
            map.clear();
        }

        return res;
    }

    private int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx * dx + dy * dy;
    }
}
