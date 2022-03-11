package com.lis.leetcode.swardoffer;

/**
 * 4. 替换字符串中的空格
 * 题目描述： 将一个字符串中的空格替换成“%20”。 例如： 当字符串为 We Are
 * Happy.则经过替换之后的字符串为 We%20Are%20Happy。
 * 思路： 从后往前复制， 数组长度会增加， 或使用 StringBuilder、 StringBuffer 类
 */
public class Quiz04 {

    /**
     * 用一个变量能来存在str当前的值
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        if (null == str) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(" ")) {
                sb.append("%20");
            } else {
                sb.append(String.valueOf(str.charAt(i)));
            }
        }
        return sb.toString();

    }
}
