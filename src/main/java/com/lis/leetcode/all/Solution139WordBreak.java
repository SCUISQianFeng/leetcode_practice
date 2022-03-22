package com.lis.leetcode.all;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lis
 * @version 1.0
 * @date 2022-3-22
 **/
public class Solution139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (null == s || s.length() == 0) {
            return true;
        }
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }

            }
        }
        return dp[len];
    }


    public static void main(String[] args) {
        Solution139WordBreak solu = new Solution139WordBreak();
        List<String> wordDict = Stream.of("cats", "dog", "sand", "and", "cat").collect(Collectors.toList());
        System.out.println(solu.wordBreak("catsandog", wordDict));
    }
}
