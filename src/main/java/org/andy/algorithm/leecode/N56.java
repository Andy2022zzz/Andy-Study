package org.andy.algorithm.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: Andy
 * @createTime: 2024-03-17 23:43
 * @description: 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [start, end] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class N56 {

    public int[][] merge(int[][] intervals) {
        // 按照区间的开始进行排序
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        int length = intervals.length;
        if (length == 1) {
            return intervals;
        }
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        
        for (int i = 0; i < length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            } else {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
}
