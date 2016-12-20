package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Gray Code
 *
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 *
 * KeyWords: BackTracking
 * Difficulty: Medium
 *
 * 000
 * 001
 * 011
 * 010   前面一半与n-1时对应的值相等
 * 110
 * 111
 * 101
 * 100   后面一半相当于将前面一半的顺序倒过来，然后在前面加一
 *
 */
public class LeetCode089 {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(0);
            return list;
        }
        if (n == 1) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(0);
            list.add(1);
            return list;
        }
        List<Integer> grayM = grayCode(n - 1);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < Math.pow(2,n); i++) {
            if (i < Math.pow(2, n-1)) { //前面一半的数字不变
                list.add(grayM.get(i));
            } else { //后面一半的数字反向排列，再在前面添加一个‘1’
                int res =  grayM.get( (int)Math.pow(2, n) - i - 1 ) + (int)Math.pow(2, n - 1);
                list.add(res);
            }
        }
        return list;
    }

    //Better Solution: The idea is simple. G(i) = i^ (i/2).
    public List<Integer> grayCode2(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }
}
