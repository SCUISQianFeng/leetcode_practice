package com.lis.leetcode.lc.middle.SortAndSearch;

/**
 * ClassName LC003
 * 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvsehe/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author Lis on 2022/3/6
 **/
public class LC003 {
    public int findKthLargest(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        headify(nums, len);
        for (int i = 0; i < len; i++) {
            if (k <= 1) {
                res = nums[0];
                break;
            }
            k--;
            int last = len - 1 - i;
            swap(nums, 0, last);
            heap(nums, last, 0);
        }
        return res;

    }

    public void headify(int[] tree, int n) {
        int temp = (n - 1 - 1) / 2;
        for (int i = temp; i >= 0; i--) {
            heap(tree, n, i);
        }
    }

    private void heap(int[] tree, int n, int i) {
        int leftIdx = 2 * i + 1;
        int rightIdx = 2 * i + 2;
        // 默认根节点为最大值的索引
        int max = i;
        if (leftIdx < n && tree[leftIdx] > tree[max]) {
            max = leftIdx;
        }
        if (rightIdx < n && tree[rightIdx] > tree[max]) {
            max = rightIdx;
        }

        if (max != i) {
            swap(tree, max, i);
            // 递归堆化子树
            heap(tree, n, max);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
