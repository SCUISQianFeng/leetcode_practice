package com.lis.leetcode.lc.base.str;

import java.util.Objects;

/**
 * LC020
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-23 11:07
 */
public class LC020 {

  /**
   * 编写一个函数来查找字符串数组中的最长公共前缀。
   *
   * <p>如果不存在公共前缀，返回空字符串 ""。
   *
   * <p>
   *
   * <p>示例 1：
   *
   * <p>输入：strs = ["flower","flow","flight"] 输出："fl" 示例 2：
   *
   * <p>输入：strs = ["dog","racecar","car"] 输出："" 解释：输入不存在公共前缀。
   *
   * <p>提示：
   *
   * <p>1 <= strs.length <= 200 0 <= strs[i].length <= 200 strs[i] 仅由小写英文字母组成 相关标签 字符串
   *
   * <p>作者：力扣 (LeetCode)
   * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnmav1/ 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public String longestCommonPrefix(String[] strs) {
    if (Objects.isNull(strs) || 0 == strs.length) {
      return null;
    }

    String pre = strs[0];
    int i = 1;
    while (i < strs.length) {
      while (strs[i].indexOf(pre) != 0) {
        pre = pre.substring(0, pre.length() - 1);
      }
      i++;
    }
    return pre;
  }
}
