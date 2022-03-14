package com.lis.leetcode.lc.base.list;

import com.lis.leetcode.lc.common.ListNode;

/**
 * LC004
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-24 19:34
 */
public class LC004 {

  /**
   * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
   *
   * <p>
   *
   * <p>示例 1：
   *
   * <p>输入：l1 = [1,2,4], l2 = [1,3,4] 输出：[1,1,2,3,4,4] 示例 2：
   *
   * <p>输入：l1 = [], l2 = [] 输出：[] 示例 3：
   *
   * <p>输入：l1 = [], l2 = [0] 输出：[0]
   *
   * <p>提示：
   *
   * <p>两个链表的节点数目范围是 [0, 50] -100 <= Node.val <= 100 l1 和 l2 均按 非递减顺序 排列 相关标签 递归 链表
   *
   * <p>Java
   *
   * <p>作者：力扣 (LeetCode)
   * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnbp2/ 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (null == l1 && null == l2) {
      return null;
    } else if (null == l1 && null != l2) {
      return l2;
    } else if (null != l1 && null == l2) {
      return l1;
    } else {
      // 先找到头结点
      ListNode nHead = null;
      if (l1.val > l2.val) {
        nHead = l2;
        l2 = l2.next;
      } else if (l1.val < l2.val) {
        nHead = l1;
        l1 = l1.next;
      } else {
        nHead = l1;
        l1 = l1.next;
      }
      ListNode point = nHead;
      while (l1 != null && l2 != null) {
        if (l1.val > l2.val) {
          nHead.next = l2;
          l2 = l2.next;
          nHead = nHead.next;
        } else {
          // 相同元素用第一链表
          nHead.next = l1;
          l1 = l1.next;
          nHead = nHead.next;
        }
      }
      if (null == l1 && null != l2) {
        while (l2 != null) {
          nHead.next = l2;
          l2 = l2.next;
          nHead = nHead.next;
        }
      } else if (null != l1 && null == l2) {
        while (l1 != null) {
          nHead.next = l1;
          l1 = l1.next;
          nHead = nHead.next;
        }
      } else {
        return point;
      }
      return point;
    }
  }

  public static void main(String[] args) {
    //    ListNode l1 = new ListNode(1);
    //    ListNode l2 = new ListNode(2);
    //    ListNode l3 = new ListNode(4);
    //    ListNode l4 = new ListNode(1);
    //    ListNode l5 = new ListNode(3);
    //    ListNode l6 = new ListNode(4);
    //    l2.next = l3;
    //    l1.next = l2;
    //    l5.next = l6;
    //    l4.next = l5;

    ListNode l1 = new ListNode(-9);
    ListNode l2 = new ListNode(3);
    ListNode l4 = new ListNode(5);
    ListNode l5 = new ListNode(7);
    l1.next = l2;
    l4.next = l5;
    LC004 lc004 = new LC004();
    ListNode result = lc004.mergeTwoLists(l1, l4);
    while (result != null) {
      System.out.println(result.val);
      result = result.next;
    }
  }
}
