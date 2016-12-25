package LeetCode;

/**
 * Climbing Stairs
 * <p>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * KeyWords: Dynamic Programing
 * Difficulty: Easy
 */
public class LeetCode070_ClimbingStairs {
    //Time Limit Exceeded
    public int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        return result;
    }

    //Elegant Solution
    public int climbStairs2(int n) {
        int a = 1, b = 1;
        while (n-- > 0)
            a = (b += a) - a;
        return a;
    }

    //
    public int climbStairs3(int n) {
        if(n == 1 || n<=0) return 1;
        int count=1;
        int a = 1, b = 1, tmp ;
        while(count++ < n) {
            tmp = a;
            a = a+b;
            b = tmp;
        }
        return a;
    }
}
