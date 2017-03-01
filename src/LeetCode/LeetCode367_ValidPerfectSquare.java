package LeetCode;

/**
 * Valid Perfect Square
 * <p>
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Note: Do not use any built-in library function such as sqrt.
 * <p>
 * Example 1:
 * <p>
 * Input: 16
 * Returns: True
 * Example 2:
 * <p>
 * Input: 14
 * Returns: False
 * <p>
 * KeyWords: Binary Search, Math
 * Difficulty: Easy
 */
public class LeetCode367_ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 1) return false;
        long left = 1, right = num;// long type to avoid 2147483647 case

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long t = mid * mid;
            if (t > num) {
                right = mid - 1;
            } else if (t < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    //a square number is 1+3+5+7+... Time Complexity O(sqrt(N))
    public boolean isPerfectSquare2(int num) {
        if (num < 1) return false;
        for (int i = 1; num > 0; i += 2)
            num -= i;
        return num == 0;
    }
}
