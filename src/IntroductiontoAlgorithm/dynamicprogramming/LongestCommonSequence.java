package IntroductiontoAlgorithm.dynamicprogramming;

/**
 * Created by wesley on 2016/10/17.
 */

// c[i][j]表示Xi,Yj的LCS长度
public class LongestCommonSequence {
    public void lcs_length(char[] x, char[] y, int[][] c) {
        int m = x.length;
        int n = y.length;
        for (int i = 0; i < m+1; i++) {
            c[i][0] = 0;
        }
        for (int j = 1; j < n+1; j++) {
            c[0][j] = 0;
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (x[i-1] == y[j-1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                } else {
                    c[i][j] = c[i][j - 1];
                }
            }
        }
    }

    public void print_lcs(int[][] c ,char[] x,char[] y,int m,int n){

        if(m==0||n==0)
            return;
        if(x[m-1] == y[n-1]){
            print_lcs(c,x,y,m-1,n-1);
            System.out.print(x[m-1]);
        }else if(c[m - 1][n] >= c[m][n - 1])
            print_lcs(c,x,y,m-1,n);
        else
            print_lcs(c, x,y, m, n-1);
    }

    public static void main(String[] args){
        LongestCommonSequence lcs =new LongestCommonSequence();
//        char[] x= {'A','B','C','B','D','A','B'};
//        char[] y={'B','D','C','A','B','A'};
        char[] x={'1','0','1','0','1','0','1'};
        char[] y={'0','1','0','1','1','0','1','1','0'};
        int m= x.length,n=y.length;
        int[][] c = new int[m+1][n+1];
        lcs.lcs_length(x,y,c);
        lcs.print_lcs(c,x,y,m,n);

    }
}
