package divide_conquer;

//三种方式计算最大子序列的值
//1.双重循环遍历,记录最大值
//2.分治法,将最大值的求法分成三个部分,分别是左边最大值,右边最大值和跨中间的最大值
//3.联机策略,利用了动态规划的思想.

/**
 * Created by wesley on 2016/10/3.
 */
public class FindMaxSubarray {
    //O(n*n)
    public static int getMaxSeq1(int[] l, int n) {
        int thisSum, maxSum = 0;
        for (int i = 0; i < n; i++) {
            thisSum = 0;
            for (int j = i; j < n; j++) {
                thisSum += l[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    public static int maxSubSum(int[] l, int left, int right) {
        if (left == right) {
            if (l[left] >= 0)
                return l[left];
            else
                return 0;
        }

        int center = (left + right) / 2;
        int maxLeftSum = maxSubSum(l, left, center);
        int maxRightSum = maxSubSum(l, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += l[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += l[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        return Math.max(maxLeftSum, Math.max(maxRightBorderSum + maxLeftBorderSum, maxRightSum));
    }

    // O(nlog(n))
    public static int getMaxSeq2(int[] l, int n) {

        return maxSubSum(l, 0, n - 1);
    }

    // O(n)
    public static int getMaxSeq3(int[] l, int n) {
        int maxSum = 0;
        int thisSum = 0;
        for (int i = 0; i < n; i++) {
            thisSum += l[i];
            if (thisSum < 0) {
                thisSum = 0;
            }
            if (thisSum > maxSum) {
                maxSum = thisSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {4, -3, 5, 2, -1, 2, 6, -2, 3};
        int max = getMaxSeq1(a, a.length);
        System.out.println(max + "");
        max = getMaxSeq3(a, a.length);
        System.out.println(max + "");
    }
}
