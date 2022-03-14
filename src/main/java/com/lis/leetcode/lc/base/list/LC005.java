package com.lis.leetcode.lc.base.list;

import com.lis.leetcode.lc.common.ListNode;

import java.util.Stack;

/**
 * LC005
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-25 17:56
 */
public class LC005 {

  /**
   * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
   *
   * <p>
   *
   * <p>示例 1：
   *
   * <p>输入：head = [1,2,2,1] 输出：true 示例 2：
   *
   * <p>输入：head = [1,2] 输出：false
   *
   * <p>提示：
   *
   * <p>链表中节点数目在范围[1, 105] 内 0 <= Node.val <= 9
   *
   * <p>进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
   *
   * <p>相关标签 栈 递归 链表 双指针
   *
   * <p>作者：力扣 (LeetCode)
   * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnv1oc/ 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public boolean isPalindrome(ListNode head) {
    // 1、先找到链表的中间节点 2、反转后一部分节点

    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    if (fast != null) {
      // 链表总的节点数奇数 slow正好是中间节点 需要再走一步
      slow = slow.next;
    }
    slow = this.reverseList(slow);
    fast = head;
    while (slow != null) {
      if (slow.val != fast.val) {
        return false;
      }
      slow = slow.next;
      fast = fast.next;
    }
    return true;
  }

  public boolean isPalindromeWithStack(ListNode head) {
    ListNode point = head;
    Stack<Integer> stack = new Stack<>();
    // 入栈
    while (point != null) {
      stack.push(point.val);
      point = point.next;
    }
    // 出栈
    while (!stack.isEmpty()) {
      if (head.val != stack.pop()) {
        return false;
      }
      head = head.next;
    }
    return true;
  }

  private ListNode reverseList(ListNode head) {
    ListNode point = null;
    // 测试链表反转
    while (head != null) {
      ListNode next = head.next;
      head.next = point;
      head = head.next;
      point = head;
      head = next;
    }
    return point;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(-9);
    ListNode l2 = new ListNode(3);
    ListNode l3 = new ListNode(5);
    ListNode l4 = new ListNode(3);
    ListNode l5 = new ListNode(-9);
    l4.next = l5;
    l3.next = l4;
    l2.next = l3;
    l1.next = l2;
    LC005 lc005 = new LC005();
    boolean result = lc005.isPalindromeWithStack(l1);
    System.out.println(result);
  }
}
