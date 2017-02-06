package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle
 *
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 * KeyWords: Array, ArrayList
 * Difficulty: Easy
 */
public class LeetCode118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (numRows <= 0) return lists;
        List<Integer> list1 = new ArrayList<Integer> ();
        list1.add(1);
        lists.add(list1);
        if (numRows == 1) return lists;
        List<Integer> oldList = null;
        for (int i = 2; i <=numRows; ++i) {
            List<Integer> newList = new ArrayList<Integer> ();
            newList.add(1);
            newList.add(1);
            for (int j = 1; j < i - 1; ++j) {
                newList.add(j, oldList.get(j) + oldList.get(j - 1));
            }
            lists.add(newList);
            oldList = newList;
        }

        return lists;

    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) return result;
        List<Integer> tm = new ArrayList<>();
        tm.add(1);
        result.add(tm);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1)
                    tmp.add(1);
                else
                    tmp.add(result.get(i - 2).get(j - 1) + result.get(i - 2).get(j));
            }
            result.add(tmp);
        }
        return result;
    }
}
