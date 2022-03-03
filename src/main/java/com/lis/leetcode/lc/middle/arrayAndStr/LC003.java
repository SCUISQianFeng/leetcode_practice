package com.lis.leetcode.lc.middle.arrayAndStr;

import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LC003 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * <p>字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * <p>
 *
 * <p>示例 1:
 *
 * <p>输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"] 输出:
 * [["bat"],["nat","tan"],["ate","eat","tea"]] 示例 2:
 *
 * <p>输入: strs = [""] 输出: [[""]] 示例 3:
 *
 * <p>输入: strs = ["a"] 输出: [["a"]]
 *
 * <p>提示：
 *
 * <p>1 <= strs.length <= 104 0 <= strs[i].length <= 100 strs[i] 仅包含小写字母
 *
 * <p>作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvaszc/ 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author Lis
 * @version 1.0
 * @date 2022-2-24 9:53
 */
public class LC003 {
    /**
     * 建一个Map<String, List<String>>
     * 将每个字符串拆成字符数组后排序后再转成string，如果这个string已经在map中，则添加到对应的list中
     * 如果没有这个key，则新增一个list，最后取出所有的list
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>(new ArrayList<>());
        }
        Map<String, List<String>> mapList = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
          String str = strs[i];
          char[] strChar = str.toCharArray();
          Arrays.sort(strChar);
          String newStr = String.valueOf(strChar);
          if (mapList.containsKey(newStr)) {
              mapList.get(newStr).add(str);
          } else {
              mapList.put(newStr, Stream.of(str).collect(Collectors.toList()));
          }
        }
        return new ArrayList<>(new ArrayList<>(mapList.values()));
    }

  public static void main(String[] args) {
//    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//    String[] strs = {""};
    String[] strs = {"a"};
      List<List<String>> res = LC003.groupAnagrams(strs);
    System.out.println(Arrays.toString(res.toArray()));
  }
}
