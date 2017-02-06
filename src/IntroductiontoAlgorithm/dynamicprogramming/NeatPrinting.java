package IntroductiontoAlgorithm.dynamicprogramming;

import java.util.Scanner;

/**
 * Created by wesley on 2016/10/26.
 *
 * 考虑在一个打印机上整齐地打印一段文章的问题。输入的正文是n个长度分别为L1、L2、……、Ln（以字符个数度量）的单词构成的序列。
 * 我们希望将这个段落在一些行上整齐地打印出来，每行至多M个字符。“整齐度”的标准如下：如果某一行包含从i到j的单词（i<j），且单
 * 词之间只留一个空格，则在行末多余的空格字符个数为 M - (j-i) - (Li+ …… + Lj)，它必须是非负值才能让该行容纳这些单词。我们
 * 希望所有行（除最后一行）的行末多余空格字符个数的立方和最小。
 * W[k][i]代表将k到i的单词写入一行时，该行的多余空格数的立方。
 *
 *   W[k][i] = (M - i + k -(Lk+....+Li))^3
 *   R[i] = min{ R[k] + W[k+1, i] }  其中 1 <= k < i
 *
 */

//len 表示的是从1到i的总长度
public class NeatPrinting {
    public int  neat_printing(int[] len,int n,int m){
        int[][] w = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            w[i][i]=-1;
            int tmp = m - (len[i] - len[i-1]);
            if(tmp>=0){
                w[i][i]=tmp*tmp*tmp;
            }
            for(int j=i+1;j<=n;j++){
                w[i][j]=-1;
                tmp = m - (len[j] - len[i-1]);
                if(tmp>=0){
                    w[i][j]=tmp*tmp*tmp;
                }
            }
        }

        int[] dp =new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            dp[i]=-1;
            for(int k=i;k>0;k--){
                if(w[k][i]<0)
                    break;
                if(dp[i]<0)
                    dp[i]=dp[k-1]+w[k][i];
                else
                    dp[i]=Math.min(dp[i],dp[k-1]+w[k][i]);
            }
        }
        return dp[n];
    }
    //m为每行的字母个数，n为单词的数目，还要输入每个单词的长度
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[] len = new int[n+1];
        len[0]=0;
        for(int i=1;i<=n;i++){
            len[i]=input.nextInt()+len[i-1];
        }
        NeatPrinting np = new NeatPrinting();
        int result = np.neat_printing(len,n,m);
        System.out.println(result);
    }
}
