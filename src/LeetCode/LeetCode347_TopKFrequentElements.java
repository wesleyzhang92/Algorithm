package LeetCode;

import java.util.*;

/**
 * Top K Frequent Elements
 * <p>
 * Given a non-empty array of integers, return the k most frequent elements.
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * <p>
 * KeyWords: Hash Table, Heap, Bucket Sort
 * Difficulty: Medium
 */
public class LeetCode347_TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i]))
                hm.put(nums[i], hm.get(nums[i]) + 1);
            else
                hm.put(nums[i], 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];//定义足够数量的桶
        for (int key : hm.keySet())//按“键”遍历
        {
            int count = hm.get(key);//获取数值为key的元素出现的频次
            //把出现频次相同的元素“扔”到序号等于频次的桶中
            if (bucket[count] == null)
                bucket[count] = new ArrayList<Integer>();
            bucket[count].add(key);
        }
        List<Integer> ls = new ArrayList<Integer>();
        for (int i = nums.length; i > 0; i--)//注意i的起始值，当数组只有一个数据时
        {
            if (bucket[i] != null && ls.size() < k)
                ls.addAll(bucket[i]);
        }
        return ls;
    }


    // use maxHeap. Put entry into maxHeap so we can always poll a number with largest frequency
    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }


}
