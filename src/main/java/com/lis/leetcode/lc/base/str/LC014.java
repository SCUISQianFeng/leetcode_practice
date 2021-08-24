package com.lis.leetcode.lc.base.str;

/**
 * LC014
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-17 10:04
 */

public class LC014 {
    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     *  
     *
     * 示例：
     *
     * s = "leetcode"
     * 返回 0
     *
     * s = "loveleetcode"
     * 返回 2
     *  
     *
     * 提示：你可以假定该字符串只包含小写字母。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * */

    public int firstUniqChar(String s) {
        if (null == s) {
            return -1;
        }

        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            char sc = sChar[i];
             if (s.lastIndexOf(sc) == s.indexOf(sc)) {
                 return i;
             }
        }
        return -1;
    }
}
