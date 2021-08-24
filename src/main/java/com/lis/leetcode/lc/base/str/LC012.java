package com.lis.leetcode.lc.base.str;

import java.util.Arrays;

/**
 * LC012
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-17 9:51
 */
public class LC012 {

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     *
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * 示例 2：
     *
     * 输入：["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhbqj/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * */

    public void reverseString(char[] s) {
        // 直接交换位置
        if (null == s || s.length == 0) {
            return;
        }
        int leftPoint = 0;
        int rightPoint = s.length - 1;
        while (leftPoint < rightPoint) {
            char temp = s[leftPoint];
            s[leftPoint] = s[rightPoint];
            s[rightPoint] = temp;
            leftPoint++;
            rightPoint--;
        }
    }



    public static void main(String[] args) {
        LC012 lc012 = new LC012();
        char[] s = new char[]{'h','e','l','l','o'};
        lc012.reverseString(s);
        System.out.println(Arrays.toString(s));

    }
}
