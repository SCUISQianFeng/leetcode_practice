package com.lis.leetcode.lc.middle.arrayAndStr;

/**
 * LC006
 *
 * <p>给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * <p>如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [1,2,3,4,5] 输出：true 解释：任何 i < j < k 的三元组都满足题意 示例 2：
 *
 * <p>输入：nums = [5,4,3,2,1] 输出：false 解释：不存在满足题意的三元组 示例 3：
 *
 * <p>输入：nums = [2,1,5,0,4,6] 输出：true 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5]
 * == 6
 *
 * <p>作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvvuqg/ 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author Lis
 * @version 1.0
 * @date 2022-2-23 17:44
 */
public class LC006 {
	public boolean increasingTriplet(int[] nums) {
		if (null == nums || nums.length < 3) {
			return false;
		}
		int small = Integer.MAX_VALUE;
		int mid = Integer.MAX_VALUE;
		for(int num: nums) {
			if (num <= small) {
				small = num;
			} else if (num <= mid) {
				mid = num;
			} else {
				return true;
			}
		}
		return false;
	}

  public static void main(String[] args) {
	  //
  }
}
