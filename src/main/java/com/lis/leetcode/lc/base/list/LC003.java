package com.lis.leetcode.lc.base.list;

import com.lis.leetcode.lc.common.ListNode;

import java.util.Stack;

/**
 * LC003
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-24 18:31
 */
public class LC003 {

  /**
   * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
   *
   * <p>示例 1：
   *
   * <p>输入：head = [1,2,3,4,5] 输出：[5,4,3,2,1] 示例 2：
   *
   * <p>输入：head = [1,2] 输出：[2,1] 示例 3：
   *
   * <p>输入：head = [] 输出：[]
   *
   * <p>提示：
   *
   * <p>链表中节点的数目范围是 [0, 5000] -5000 <= Node.val <= 5000
   *
   * <p>进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
   *
   * <p>相关标签 递归 链表
   *
   * <p>作者：力扣 (LeetCode)
   * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnhm6/ 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param head
   * @return
   */
  public ListNode reverseList(ListNode head) {
    // 双链表处理
    ListNode nHead = null;
    while (head != null) {
      // 先走一步 head: 1, point: 2, nHead:null
      ListNode point = head.next;
      // 重新连接
      head.next = nHead;
      // 更新链表
      nHead = head;
      head = point;
      // 此时head: 2, nHead: 1
    }
    return nHead;
  }

  public ListNode reverseListWithStack(ListNode head) {
    // 栈处理
    Stack<ListNode> stack = new Stack<>();
    while (head != null) {
      stack.push(head);
      head = head.next;
    }
    // 判空很重要，不然报Null
    if (stack.isEmpty()) {
      return null;
    }
    ListNode point = stack.pop();
    ListNode nHead = point;
    while (!stack.isEmpty()) {
      ListNode temp = stack.pop();
      point.next = temp;
      point = point.next;
    }
    // 防止成闭环
    point.next = null;
    return nHead;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    ListNode l5 = new ListNode(5);
    l5.next = null;
    l4.next = l5;
    l3.next = l4;
    l2.next = l3;
    l1.next = l2;
    LC003 lc003 = new LC003();
    ListNode result = lc003.reverseListWithStack(l1);
    while (result != null) {
      System.out.println(result.val);
      result = result.next;
    }
  }
}
