package com.lis.leetcode.lc.middle.arrayAndStr;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LC005
 *
 * <p>给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：s = "babad" 输出："bab" 解释："aba" 同样是符合题意的答案。 示例 2：
 *
 * <p>输入：s = "cbbd" 输出："bb"
 *
 * <p>作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvn3ke/ 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author Lis
 * @version 1.0
 * @date 2022-2-24 14:00
 */
public class LC005 {
    /**
     * 以当前字符所在的位置为中心（奇数），比较左右的两个字符是否相同
     * 以当前字符所在的位置以及之后一个字符为中心（偶数），比较左右的两个字符是否相同
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
    	if (s.length() < 2) {
    		return s;
	    }
	    List<String> resultList = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) != s.charAt(i + 1)) {
				// 奇数
				resultList.add( longestPalindrome(s, i, i));
			} else {
				// 奇数 + 偶数
				resultList.add(longestPalindrome(s, i, i + 1));
				resultList.add(longestPalindrome(s, i, i));
			}
        }
        int maxLen = 0;
        int index = 0;
	    for (int i = 0; i < resultList.size(); i++) {
	    	if (resultList.get(i).length() > maxLen) {
	    		maxLen = resultList.get(i).length();
	    		index = i;
		    }
	    }
        return resultList.get(index);
    }

    private static String longestPalindrome(String s, int start1, int start2) {
    	int maxLen = 0;
    	int i = start1;
    	int j = start2;
        while(i >= 0 && j < s.length()) {
            if (s.charAt(i--) == s.charAt(j++)) {
                maxLen++;
            } else {
            	break;
            }
        }
	    return s.substring(start1 - maxLen + 1, start2 + maxLen);
    }

  public static void main(String[] args) {
    	String str = "a";
	  String res = LC005.longestPalindrome(str);
    System.out.println(res);
  }
}
