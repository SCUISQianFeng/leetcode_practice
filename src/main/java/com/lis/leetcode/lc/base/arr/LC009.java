package com.lis.leetcode.lc.base.arr;

import java.util.*;

/**
 * LC009
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-16 18:16
 */
public class LC009 {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     * <p>
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     * <p>
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *  
     * <p>
     * 提示：
     * <p>
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * 只会存在一个有效答案
     * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public int[] twoSum(int[] nums, int target) {
        // 使用map
        if (null == nums || nums.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> idxList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                // 之所以这里能成立，是因为就算是重复的数字，如果相加结果不是target，即使重复再多次，只保留一次就够了（有可能和其他数字相加等于target
                // 如果重复数字相加的结果等于target，那么在这一步就能返回值
                idxList.add(i);
                idxList.add(map.get(target - nums[i]));
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        int[] idxArr = new int[]{idxList.size()};
        for (int i = 0; i < idxArr.length; i++) {
            idxArr[i] = idxList.get(i);
        }
        return idxArr;

    }

    public static void main(String[] args) {
        LC009 lc009 = new LC009();
        int[] nums = new int[]{3,3};
        int target = 6;
        System.out.println(Arrays.toString(lc009.twoSum(nums, target)));
    }

}
