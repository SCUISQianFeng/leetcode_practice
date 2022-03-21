package com.lis.leetcode.all;

/**
 * ClassName Solution091NumDecodings
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  如果连续的两位数符合条件，就相当于一个上楼梯的题目，可以有两种选法：
 *         1.一位数决定一个字母
 *         2.两位数决定一个字母
 *         就相当于dp(i) = dp[i-1] + dp[i-2];
 *     如果不符合条件，又有两种情况
 *         1.当前数字是0：
 *             不好意思，这阶楼梯不能单独走，
 *             dp[i] = dp[i-2]
 *         2.当前数字不是0
 *             不好意思，这阶楼梯太宽，走两步容易扯着步子，只能一个一个走
 *             dp[i] = dp[i-1];
 * @author Lis on 2022/3/21
 **/
public class Solution091NumDecodings {
    public int numDecodings(String s) {
        if (null == s || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        if (len == 1) {
            return 1;
        }
        int[] dp = new int[len+ 1];
        dp[0] = 1;
        for (int i = 0; i < len; i++) {
            // 如果当前位不是0，则dp[i+1]至少是等于dp[i]的结果
            dp[i + 1] = s.charAt(i) == '0' ? 0 : dp[i];
            if (i > 0 && (s.charAt(i-1) == '1'  || (s.charAt(i-1) == '2' && s.charAt(i) <= '6' ))) {
                // 如果之前以为也在范围内，则可以加上dp[i-1]的结果，否则dp[i-1. i]这两个字符是不能转换成一个字符的
                dp[i + 1] += dp[i- 1];
            }
        }
        return dp[len];
    }
}
