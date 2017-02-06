package IntroductiontoAlgorithm.dynamicprogramming;

/**
 * Created by wesley on 2016/10/25.
 */
//最优子结构
//假设 X[0 ... n-1]  是给定的序列，长度为n.  让 L(0,n-1) 表示 序列 X[0 ... n-1] 的最长回文子序列的长度。
//1. 如果X的最后一个元素和第一个元素是相同的，这时：L(0, n-1) = L(1, n-2) + 2 ,  还以 “BBABCBCAB” 为例，第一个和最后一个相同，因此 L(1,n-2) 就表示蓝色的部分。
//2. 如果不相同：L(0, n-1) = MAX ( L(1, n-1) ,  L(0, n-2) )。 以”BABCBCA” 为例，L(1,n-1)即为去掉第一个元素的子序列，L(0, n-2)为去掉最后一个元素。
public class LongestPalindromeSequence {
    public int lps_length(char[] l,int i,int j){
        if(i==j)
            return 1;
        if(i>j)
            return 0;
        if(l[i]==l[j])
            return lps_length(l,i+1,j-1)+2;
        else
            return Math.max(lps_length(l,i+1,j),lps_length(l,i,j-1));
    }

    public void lps(char[] l,int n,int[][] dp){
        for(int i=0;i<n;i++)
            dp[i][i]=1;
        for(int i=1; i<n; i++) {
            int tmp = 0;
            //考虑所有连续的长度为i+1的子串. 该串为 str[j, j+i]
            for (int j = 0; j + i < n; j++) {
                //如果首尾相同
                if (l[j] == l[j + i]) {
                    tmp = dp[j + 1][j + i - 1] + 2;
                } else {
                    tmp = Math.max(dp[j + 1][j + i], dp[j][j + i - 1]);
                }
                dp[j][j + i] = tmp;
            }
        }
    }

    public void print_lps(int[][] dp,char[] l,int m,int n){
        if(m>n)
            return;
        if(m==n) {
            System.out.print(l[m]);
            return;
        }
        if(l[m]==l[n]){
            System.out.print(l[m]);
            print_lps(dp,l,m+1,n-1);
            System.out.print(l[m]);
        }else if(dp[m][n-1]>dp[m+1][n])
            print_lps(dp,l,m,n-1);
        else
            print_lps(dp,l,m+1,n);
    }

    public static void main(String[] args){
        char[] l = {'c','h','a','r','a','c','t','e','r'};
        int[][] c = new int[l.length][l.length];
        LongestPalindromeSequence lps = new LongestPalindromeSequence();
        int s = lps.lps_length(l,0,l.length-1);
        System.out.print(s);
        lps.lps(l,l.length-1,c);
        lps.print_lps(c,l,0,l.length-1);
    }
}
