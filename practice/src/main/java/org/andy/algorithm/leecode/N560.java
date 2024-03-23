package org.andy.algorithm.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Andy
 * @createTime: 2024-03-17 19:59
 * @description: 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 */
public class N560 {

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            pre += num;
            // 如果包括前面的数组中有合为 pre-k 的位置，那么这个位置和当前位置之间的值则为k
            // 这样的位置可能有多个，也就是存在多个子数组
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
