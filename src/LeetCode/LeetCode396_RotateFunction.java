package LeetCode;

/**
 * Rotate Function
 * Given an array of integers A and let n to be its length.
 * <p>
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
 * <p>
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * <p>
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 * <p>
 * Note:
 * n is guaranteed to be less than 105.
 * <p>
 * Example:
 * <p>
 * A = [4, 3, 2, 6]
 * <p>
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * <p>
 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 */
public class LeetCode396_RotateFunction {

    //答案超时
    public int maxRotateFunction(int[] A) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int tmp = 0;
            for (int j = 0; j < A.length; j++) {
                tmp += ((j + i) % A.length) * A[j];
            }
            result = Math.max(result, tmp);
        }
        return result;
    }

    //解答采用数学方法
    /*
    * F(k) - F(k-1) = Bk[1] + Bk[2] + ... + Bk[n-1] + (1-n)Bk[0]
              = (Bk[0] + ... + Bk[n-1]) - nBk[0]
              = sum - nBk[0]
     k = 0; B[0] = A[0];
     k = 1; B[0] = A[len-1];
     k = 2; B[0] = A[len-2];
     */
    public int maxRotateFunction2(int[] A) {
        int n = A.length;
        int sum = 0;
        int candidate = 0;

        for (int i = 0; i < n; i++) {
            sum += A[i];
            candidate += A[i] * i;
        }
        int best = candidate;

        for (int i = n - 1; i > 0; i--) {
            candidate = candidate + sum - A[i] * n;
            best = Math.max(best, candidate);
        }
        return best;
    }
}
