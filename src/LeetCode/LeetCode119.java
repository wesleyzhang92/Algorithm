package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle II
 *
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * KeyWords: Array
 * Difficulty: Easy
 */
public class LeetCode119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(0,1);
        if(rowIndex==0)
            return res;
        if(rowIndex==1){
            res.add(1);
            return res;
        }
        else{
            List<Integer> old = getRow(rowIndex-1);
            for(int i=1;i<rowIndex;i++){
                res.add(i,old.get(i)+old.get(i-1));
            }
            res.add(rowIndex,1);
        }
        return res;
    }

    //Better Solution
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0)
            return list;

        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }

    public static void main(String[] args){
        LeetCode119 solution = new LeetCode119();
        List<Integer> ls = solution.getRow2(3);
        System.out.println(ls);
    }
}
