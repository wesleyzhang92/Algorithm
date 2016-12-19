package LeetCode;

/**
 * Reverse Integer
 *
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows.
 * How should you handle such cases?
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * Update (2014-11-10):
 * Test cases had been added to test the overflow behavior.
 *
 * 关键词：Math、OverFlow
 * 难度：Easy
 */
public class LeetCode007 {
    public int reverse(int x) {
        int result;
        long a=0;
        if(x<0)
            result=-x;
        else
            result=x;
        while(result!=0){
            a=a*10+result%10;
            result=result/10;
        }

        if(a>Integer.MAX_VALUE||a<Integer.MIN_VALUE)
            return 0;
        return x<0 ? -(int)a : (int)a;
    }

    //Better Solution
    public int reverse2(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
}