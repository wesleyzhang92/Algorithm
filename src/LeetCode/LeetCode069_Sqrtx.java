package LeetCode;

/**
 * Sqrt(x)
 * <p>
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x.
 * <p>
 * KeyWords: Binary Search, Math
 * Difficulty: Easy
 */
public class LeetCode069_Sqrtx {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int start = 0, end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid > mid) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (start <= x / start && end > x / end) {
            return start;
        } else {
            return end;
        }

    }

    public int mySort2(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }
}
