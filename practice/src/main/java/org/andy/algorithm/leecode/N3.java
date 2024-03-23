package org.andy.algorithm.leecode;

import java.util.HashMap;

/**
 * @author: Andy
 * @createTime: 2024-03-17 17:31
 * @description: 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class N3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 如果已经存在s.charAt(i)，则将left向左移动到s.charAt(i)的下一个位置
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // s.charAt(i)的位置会一直更新成最新的
            map.put(s.charAt(i), i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
