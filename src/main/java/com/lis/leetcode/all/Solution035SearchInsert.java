package com.lis.leetcode.all;

/**
 * Solution35SearchInsert
 *
 * @author Lis
 * @version 1.0
 * @date 2021-6-8 14:02
 */
public class Solution035SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // left = right
        return nums[left] < target ? left + 1 : left;
    }

    public static void main(String[] args) {
        Solution035SearchInsert solution = new Solution035SearchInsert();
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 5;
        System.out.println(solution.searchInsert(nums, target));
    }
}
