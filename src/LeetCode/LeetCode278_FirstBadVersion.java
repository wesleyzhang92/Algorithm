package LeetCode;

/**
 * First Bad Version
 * <p>
 * You are a product manager and currently leading a team to develop a new product. Unfortunately,the latest version
 * of your product fails the quality check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the
 * following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function
 * to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * KeyWords: Binary Search
 * Difficulty: Easy
 */
public class LeetCode278_FirstBadVersion {

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int ver = 0;
        while (low < high) {
            ver = (high + low) / 2;
            if (isBadVersion(ver)) {
                high = ver;
            } else {
                low = ver + 1;
            }
        }
        return low;
    }

    private boolean isBadVersion(int version) {
        return true;
    }
}
