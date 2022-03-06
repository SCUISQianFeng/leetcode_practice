package com.lis.leetcode.lc.middle.SortAndSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName LC001
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库的sort函数的情况下解决这个问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvg25c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author Lis on 2022/3/6
 **/
public class LC001 {
    /**
     * 思路verison1: 创建一个有三个键的map<Integer, Integer>， 用位排序的方式处理, value是三个key出现的次数（map的key还是要排序）
     * 思路Version1：只需要存储0的次数和1的次数即可
     * @param nums
     * 执行用时：0 ms 在所有 Java 提交中击败了  100.00%的 用户
     * 内存消耗：39.8 MB , 在所有 Java 提交中击败了 21.12% 的用户
     */
    public void sortColors(int[] nums) {
        int zeroNum = 0;
        int oneNum = 0;
        for (Integer value: nums) {
            if (value == 0) {
                zeroNum++;
            } else if(value == 1) {
                oneNum++;
            }
        }
        Arrays.fill(nums, 0, zeroNum, 0);
        Arrays.fill(nums, zeroNum, zeroNum + oneNum, 1);
        Arrays.fill(nums, zeroNum + oneNum, nums.length,  2);
    }

    public static void main(String[] args) {
        LC001 lc = new LC001();
        int[] nums = {2,0,2,1,1,0};
        lc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
