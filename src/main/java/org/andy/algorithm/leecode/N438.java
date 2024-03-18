package org.andy.algorithm.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Andy
 * @createTime: 2024-03-17 19:38
 * @description:  找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 */
public class N438 {

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCount, pCount)) {
            // 这里比较的第一个窗口
            res.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            // 清除第一个窗口的数据，同时记录第二个窗口的数据，比较第二个窗口的数据是否一样
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];
            if (Arrays.equals(sCount, pCount)) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
