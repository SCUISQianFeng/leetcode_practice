package com.lis.leetcode.lc.middle.SortAndSearch;


import java.util.*;

/**
 * ClassName LC002
 *前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvzpxi/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author Lis on 2022/3/6
 **/
public class LC002 {
    /**
     * 用一个map存储所有数字的出现次数，在一个长度为k的队列中找出value最大的k个值
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] queue = new int[k];
        Map<Integer, Integer> map = new TreeMap<>();
        for (Integer value: nums) {
            if (!map.containsKey(value)) {
                map.put(value, 0);
            }
            map.put(value, map.get(value) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return 0 - o1.getValue().compareTo(o2.getValue());
            }
        });
        int i = 0;
        while(i < k) {
            Map.Entry<Integer, Integer> iEntry = list.get(i);
            queue[i] = iEntry.getKey();
            i++;
        }

        return queue;
    }

    public static void main(String[] args) {
        LC002 lc = new LC002();
        int[] nums = {1};
        System.out.println(Arrays.toString(lc.topKFrequent(nums, 1)));
    }
}
