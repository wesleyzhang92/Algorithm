package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wesley on 2016/12/18.
 * 全排列是将一组数按一定顺序进行排列，如果这组数有n个，那么全排列数为n!个。现以{1, 2, 3, 4, 5}为例说明如何编写全排列的递归算法。
 * 1、首先看最后两个数4, 5。 它们的全排列为4 5和5 4, 即以4开头的5的全排列和以5开头的4的全排列。由于一个数的全排列就是其本身，从而得到以上结果。
 * 2、再看后三个数3, 4, 5。它们的全排列为3 4 5、3 5 4、 4 3 5、 4 5 3、 5 3 4、 5 4 3 六组数。即以3开头的和4,5的全排列的组合、以4开头的和3,5的全排列的组合和以5开头的和3,4的全排列的组合。
 * 从而可以推断，设一组数p = {r1, r2, r3, ... ,rn}, 全排列为perm(p)，pn = p - {rn}。
 * 因此perm(p) = r1perm(p1), r2perm(p2), r3perm(p3), ... , rnperm(pn)。
 * 当n = 1时perm(p} = r1。为了更容易理解，将整组数中的所有的数分别与第一个数交换，这样就总是在处理后n-1个数的全排列。
 *
 * 关键词：DFS、List、递归
 * 难度：Medium
 */
public class LeetCode046 {
//  方法一，深度优先搜索，递归解法
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        dfs(res, nums, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, int[] nums, int j) {
        if (j == nums.length) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(temp);
        }
        for (int i = j; i < nums.length; i++) {
            swap(nums, i, j);
            dfs(res, nums, j + 1);
            swap(nums, i, j);
        }
    }
    private void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

//  方法二：逐一向中间集添加元素，并将当中间集元素个数等于 nums 长度的时候，将中间集添加到结果集中，并终止该层递归
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                used[i] = true;
                temp.add(nums[i]);
                dfs(res, temp, nums, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

//  方法三：非递归实现，假设我们有了当前前 i 个元素的组合，当第 i+1个元素加入时，我们需要做的是将这个元素加入之前的每一个结果，并且放在每个
//  结果的每个位置，因为之前的结果没有重复，所以加入新元素的结果也不会有重复（这里是假定数字集合没有重复）
    public List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null)
            return res;
        List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        res.add(first);
        for(int i = 1; i < nums.length; i++) {
            List<List<Integer>> newRes = new ArrayList<>();
            for(List<Integer> temp : res) {
                int size = temp.size() + 1;
                for(int j = 0; j < size; j++) {
                    List<Integer> item = new ArrayList<>(temp);
                    item.add(j, nums[i]);
                    newRes.add(item);
                }
            }
            res = newRes;
        }
        return res;
    }



    public static void main(String[] args){
        int[] nums={1,2,3};
        LeetCode046 Solution = new LeetCode046();
        List<List<Integer>> res = Solution.permute3(nums);
        System.out.println(res);
    }
}