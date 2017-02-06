package IntroductiontoAlgorithm.dynamicprogramming;

/**
 * Created by wesley on 2016/10/14.
 */
public class MatrixChainOrder {
    private static String name = "ABCDEF";

    //矩阵Ai的规模为a[i-1]*a[i]
    private static int[] a = {30, 35, 15, 5, 10, 20, 25};
    private static int len = a.length - 1;

    private static int[][] m = new int[len][len];
    //s[i][j]记录了最优值m[i][j]的分割点
    private static int[][] s = new int[len][len];

    public static void main(String[] args) {
        System.out.print("最少需要的计算次数：");
        Compute(a, m, s);
        System.out.println();

        System.out.print("矩阵相乘的顺序为： ");
        Display(s, name, 0, len - 1);
    }

    public static void Compute(int[] a, int[][] m, int[][] s) {
        int t = 0;
        int min = 0;
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            m[i][i] = 0;
        }
        for (int l = 2; l < a.length; l++) {
            for (int i = 0; i < a.length - l; i++) {
                int j = i + l - 1;

                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    temp = m[i][k] + m[k + 1][j] + a[i] * a[k + 1] * a[j + 1];

                    if (temp < m[i][j]) {
                        min = temp;
                        m[i][j] = temp;
                        s[i][j] = k;
                    }
                }
            }
        }

        System.out.print(min);
    }

    public static void Display(int[][] s, String name, int i, int j) {
        if (i == j) {
            System.out.print(name.charAt(i));
        } else {
            System.out.print("(");
            Display(s, name, i, s[i][j]);
            Display(s, name, s[i][j] + 1, j);
            System.out.print(")");
        }
    }
}
