package com.lis.leetcode.lc.base.str;

/**
 * LC016
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-23 10:19
 */
public class LC016 {

  /**
   * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
   *
   * <p>说明：本题中，我们将空字符串定义为有效的回文串。
   *
   * <p>
   *
   * <p>示例 1:
   *
   * <p>输入: "A man, a plan, a canal: Panama" 输出: true 解释："amanaplanacanalpanama" 是回文串 示例 2:
   *
   * <p>输入: "race a car" 输出: false 解释："raceacar" 不是回文串
   *
   * <p>提示：
   *
   * <p>1 <= s.length <= 2 * 105 字符串 s 由 ASCII 字符组成 相关标签 双指针 字符串
   *
   * <p>作者：力扣 (LeetCode)
   * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xne8id/ 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public boolean isPalindrome(String s) {
    String ls = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    String rs = new StringBuffer(ls).reverse().toString();
    return ls.equals(rs);
  }

  public boolean isPalindromeWithPoint(String s) {
    char[] c = s.toCharArray();
    int i = 0;
    int j = c.length - 1;
    while (i < j) {
      while (i < j && !Character.isLetterOrDigit(c[i])) {
        i++;
      }

      while (i < j && !Character.isLetterOrDigit(c[j])) {
        j--;
      }

      if (i < j && Character.toLowerCase(c[i]) != Character.toLowerCase(c[j])) {
        return false;
      } else {
        i++;
        j--;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String s = ".,";
    LC016 lc016 = new LC016();
    boolean result = lc016.isPalindromeWithPoint(s);
    System.out.println(result);
  }
}
