package Interview;

/**
 * Created by wesley on 2016/12/22.
 * <p>
 * LinkedIn面试，二维数组的回形遍历
 */
public class twoDimensionArray {
    public static void main(String[] args) {
        int a[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };
        int time = 0;  //5行4列，输出顺序为1,2,3,4,8,12,16,20,19,18,17,13,9,5,6,7,11,15,。。
        int M = a.length;
        int N = a[0].length;
        int j = 0;


        for (int n = 0; ; n++) {
            for (j = n; j < N - n; j++) {
                time++;
                System.out.println(a[n][j]);
            }
            if (time == M * N)
                break;

            for (j = n + 1; j < M - n; j++) {
                time++;
                System.out.println(a[j][N - n - 1]);
            }
            if (time == M * N)
                break;

            for (j = N - n - 2; j >= n; j--) {
                time++;
                System.out.println(a[M - n - 1][j]);
            }
            if (time == M * N)
                break;

            for (j = M - n - 2; j >= n + 1; j--) {
                time++;
                System.out.println(a[j][n]);
            }
            if (time == M * N)
                break;
        }
    }
}
