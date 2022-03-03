package com.lis.leetcode.lc.middle.arrayAndStr;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * LC004 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * <p>
 *
 * <p>示例 1:
 *
 * <p>输入: s = "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。 示例 2:
 *
 * <p>输入: s = "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。 示例 3:
 *
 * <p>输入: s = "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。   请注意，你的答案必须是 子串
 * 的长度，"pwke" 是一个子序列，不是子串。
 *
 * <p>作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xv2kgi/ 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author Lis
 * @version 1.0
 * @date 2022-2-24 11:08
 */
public class LC004 {
    /**
     * 用一个maxSize保存最长字符串，一个list存最长的字符数组，
     * 两个指针i，j分别移动，如果j指向的字符已经在list中，则i指向j的位置，j继续前移，清空list
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        int i =  0;
        List<Character> charList = new ArrayList<>();
        for (int j = i; j < s.length(); j++) {

            if (charList.contains(s.charAt(j))) {
                // 出现重复字符
                i = j;
                // 将charList中j指向字符的位置之前的数据全部出队
                int charIndex = charList.indexOf(s.charAt(j));
                charList = charList.subList(charIndex+1, charList.size());
                // 当前字符入队列
                charList.add(s.charAt(j));
            } else {
                // 当前字符入队列
                charList.add(s.charAt(j));
                // 更新最大字符串长度
                if (charList.size() > maxLength) {
                    maxLength = charList.size();
                }
            }
          //
        }
        return maxLength;
    }

      public static void main(String[] args) {
        String str = "bbbbb";
    System.out.println(LC004.lengthOfLongestSubstring(str));
      }
}
