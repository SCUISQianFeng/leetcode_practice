package com.lis.leetcode.swardoffer;

/**
 * ClassName Quiz42_1
 * 字符串中字符的移动
 * 42.1 反转字符串
 * 题目描述： 输入一个英文句子， 翻转句子中单词的顺序， 但单词内字符的顺序不
 * 变41
 * 思路： 先将整个字符串翻转， 然后将每个单词反转。
 *
 * @author Lis on 2022/3/13
 **/
public class Quiz42_1 {
    public String reverseSentence(String sentence) {
        if (sentence == null || sentence.length() == 0 || sentence.trim().length() == 0) {
            return sentence;
        }
        String blank = " ";
        String sentenceReverse = reverse(sentence);
        String[] splitStrings = sentenceReverse.split(blank);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splitStrings.length - 1; i++) {
            sb.append(reverse(splitStrings[i])).append(blank);
        }
        sb.append(reverse(splitStrings[splitStrings.length - 1]));
        return String.valueOf(sb);
    }

    public String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return String.valueOf(sb);
    }

}
