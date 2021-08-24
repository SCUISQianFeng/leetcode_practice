package com.lis.leetcode.lc.base.str;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * LC015
 *
 * @author Lis
 * @version 1.0
 * @date 2021-8-23 9:33
 */
public class LC015 {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 提示:
     *
     * 1 <= s.length, t.length <= 5 * 104
     * s 和 t 仅包含小写字母
     * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * */

    public boolean isAnagram(String s, String t) {
        // 1、统计字符串1每个字符出现的次数；2、用字符串2的置换去减字符串1
        // 3.如果结果全是0，则是true
        Map<Character, Integer> map = new HashMap<>();
        char[] c1  = s.toCharArray();
        char[] c2  = t.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            map.put(c1[i], map.getOrDefault(c1[i], 0) + 1);
        }
        for(int i = 0; i < t.length(); i++) {
            map.put(c2[i], map.getOrDefault(c2[i], 0) - 1);
        }

        Set<Character> keySet = map.keySet();
        for (Character c : keySet) {
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        LC015 lc015 = new LC015();
        boolean result = lc015.isAnagram(s, t);
        System.out.println(result);
    }
}
