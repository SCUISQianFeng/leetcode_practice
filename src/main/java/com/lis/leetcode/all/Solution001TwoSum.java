package com.lis.leetcode.all;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution35SearchInsert
 *
 * @author Lis
 * @version 1.0
 * @date 2021-6-8 14:02
 */
public class Solution001TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0};

    }

    public static void main(String[] args) {
        Solution001TwoSum solution = new Solution001TwoSum();
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        StringBuilder sb = new StringBuilder();
        for (int i : solution.twoSum(nums, target)) {
            sb.append(i).append(", ");
        }
        System.out.println(sb);
    }
}
