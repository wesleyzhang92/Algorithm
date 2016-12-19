package dynamicprogramming;

import java.util.Scanner;

/**
 * 计划一个公司聚会
 问题描述:
 Stewart教授是一家公司总裁的顾问，这家公司正在计划一个公司的聚会。这个公司有一个层次式的结构；也就是，管理关系形成一颗以总裁为根的树。人事
 部门按每个员工喜欢聚会的程度来排名，排名是一个实数。为了使每个参加聚会者都喜欢这个聚会，总裁不希望一个雇员和她的直接上司同时参加。
 Stewart教授面对一颗描述公司结构的树，使用了左孩子右兄弟描述法。树中每个节点除了包含指针，还包含雇员的名字以及雇员喜欢聚会的排名。描述一个
 算法，它生成一张客人列表，使得客人喜欢聚会的程度的总和最大。分析你的算法的执行时间。要求你算出最大的喜欢程度和。
 Sample Input:
 n: 员工个数, 接下一行输入每个员工对这次party的喜欢程度.
 接下的n行内, 每行输入u:员工编号, num: 该员工下属的个数, vi: 该员工的第i个下属的编号(0<=i<n)

 Sample Output:
 输出最大的喜欢程度和.

 Sample Input:
 5
 2 3 5 4 4
 0 2 2 3
 2 1 1
 1 1 4
 3 0
 4 0
 6
 20 3 5 4 5 30
 0 2 2 3
 2 1 1
 3 1 4
 1 0
 4 1 5
 5 0

 Sample Output:
 13
 53

 解题思路:
 1. 每个员工可以设置2个状态state: 参加和不参加.
 2. 动态规划求解, 设状态: dp[node][0]: node员工不参加party的及其下属的最大喜欢程度.
 dp[node][1]: node员工参加party的及其下属的最大喜欢程度.
 3. 状态转移方程:
 dp[node][0] = ∑max(DP(i,0),DP(i,1)); (i是node的直接下属编号)
 dp[node][1] = a[node]+∑DP(i,0); (a[node]: node员工对聚会的喜欢程度);
 4. 最后结果是: result = max(DP(root,0) , DP(root,1));
 因为root没有上司所以要分别求2次, 最后取较大值.


 * Created by wesley on 2016/10/31.
 */

public class CompanyParty {
    int n;
    int[] like;
    int[][] dp;
    //employee[u][v]==true 表示u的下属为v
    Boolean[][] employee;
    int root;
    public CompanyParty(int n){
        this.n = n;
        this.like = new int[n];
        this.dp= new int[n][2];
        this.employee = new Boolean[n][n];
        this.root=0;
    }

    public void genTree(){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<n;i++){
            like[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                employee[i][j]=false;
        for(int i=0;i<n;i++){
            int num = sc.nextInt();
            int sbunum = sc.nextInt();
            for(int j=0;j<sbunum;j++){
                int v = sc.nextInt();
                employee[num][v]=true;
            }
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<2;j++)
                dp[i][j]=-1;
    }

    public int dp_party(int node,int state){
        if(dp[node][state]!=-1)
            return dp[node][state];
        int ans=0;
        if(state == 0) //node不参加party
        {
            for(int i = 0; i < n; ++i)
            {
                if(employee[node][i]==true)
                    ans += Math.max(dp_party(i,0),dp_party(i,1));
            }
            dp[node][state] = ans;
            return ans;
        }else{
            ans = like[node];
            for(int i = 0; i < n; ++i)
            {
                if(employee[node][i]==true)
                    ans += dp_party(i,0);
            }
            dp[node][state] = ans;
            return ans;
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CompanyParty cp = new CompanyParty(n);
        cp.genTree();
        int root =0;
        int result = Math.max(cp.dp_party(root,0),cp.dp_party(root,1));
        System.out.print(result);
    }
}
