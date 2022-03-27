package com.lis.leetcode.all;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution046Permute
 *
 * @author Lis
 * @version 1.0
 * @date 2022-3-4 10:59
 */
public class Solution046Permute {
  // 存储全局的结果
  List<List<Integer>> result = new LinkedList<>();

  public List<List<Integer>> permute(int[] nums) {
    // 记录符合条件的结果
    List<Integer> track = new LinkedList<>();
    backtrack(nums, track);
    return result;
  }

  private void backtrack(int[] nums, List<Integer> track) {
    if (track.size() == nums.length) {
      // 已经是完整的路径
      result.add(new LinkedList<>(track));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (track.contains(nums[i])) {
        // 已经遍历过的路径直接跳过
        continue;
      }
      track.add(nums[i]);
      // 加入一个节点后继续遍历可能的结果
      backtrack(nums, track);
      // 回退已经加入的节点，向上回溯
	    track.remove(track.size() - 1);
    }
  }

  public static void main(String[] args) {
	  Solution046Permute solu = new Solution046Permute();
	  int[] nums = {1,2, 3};
	  List<List<Integer>> permute = solu.permute(nums);
	  for (List<Integer> value: permute) {
      System.out.println(Arrays.toString(value.toArray()));
	  }
  }
}
