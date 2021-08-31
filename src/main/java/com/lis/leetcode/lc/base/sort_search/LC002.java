package com.lis.leetcode.lc.base.sort_search;

/**
 * LC002
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-26 14:57
 */
public class LC002 {

  /**
   * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
   *
   * <p>假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
   *
   * <p>你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用
   * API 的次数。
   *
   * <p>  示例 1：
   *
   * <p>输入：n = 5, bad = 4 输出：4 解释： 调用 isBadVersion(3) -> false 调用 isBadVersion(5) -> true 调用
   * isBadVersion(4) -> true 所以，4 是第一个错误的版本。 示例 2：
   *
   * <p>输入：n = 1, bad = 1 输出：1
   *
   * <p>提示：
   *
   * <p>1 <= bad <= n <= 231 - 1 相关标签 二分查找 交互
   *
   * <p>作者：力扣 (LeetCode)
   * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnto1s/ 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public int firstBadVersion(int n) {
    // 其实就是二分查找，具体是哪个数是正确，反正是子啊1~n之间
    int start = 1;
    int end = n;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (!isBadVersion(mid)) {
        // 向后找
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    return start;
  }

  private boolean isBadVersion(int version) {
    if (version == 4) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    LC002 lc002 = new LC002();
    int result = lc002.firstBadVersion(3);
    System.out.println(result);
  }
}
