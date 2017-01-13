package LeetCode;

/**
 * Arranging Coins
 * <p>
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * <p>
 * Given n, find the total number of full staircase rows that can be formed.
 * <p>
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * <p>
 * Example 1:
 * <p>
 * n = 5
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 * <p>
 * n = 8
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 4th row is incomplete, we return 3.
 * KeyWords: Binary Search, Math
 * Difficulty: Easy
 */
public class LeetCode441_ArrangingCoins {
    public int arrangeCoins(int n) {
        int count = 0;
        int i = 1;
        while (n - i >= 0) {
            n -= i;
            count++;
            i++;
        }
        return count;
    }

    public int arrangeCoins2(int n) {
        return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
    }


    /*
    * The problem is basically asking the maximum length of consecutive number that has the running sum lesser or equal
    * to `n`. In other word, find `x` that satisfy the following condition:
    * `1 + 2 + 3 + 4 + 5 + 6 + 7 + ... + x <= n`
    * `sum_{i=1}^x i <= n`
    * Running sum can be simplified,
    * `(x * ( x + 1)) / 2 <= n`
    * Binary search is used in this case to slowly narrow down the `x` that will satisfy the equation.
    * Note that 0.5 * mid * mid + 0.5 * mid does not have overflow issue as the intermediate result is implicitly
    * autoboxed to double data type.
    * */

    //Binary Search
    public int arrangeCoins3(int n) {
        int start = 0;
        int end = n;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) >>> 1;
            if ((0.5 * mid * mid + 0.5 * mid) <= n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start - 1;
    }
}
