package org.andy.algorithm;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Andy
 * @createTime: 2024-03-09 20:22
 * @description: class
 */
public class Solution {

    /**
     * 1. 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{};
    }

    /**
     * 49. 字母异位词分组
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>(strs.length);
        for (String str : strs) {
            String sortStr = sortString(str);
            if (strMap.containsKey(sortStr)) {
                strMap.get(sortStr).add(str);
            } else {
                strMap.put(sortStr, new ArrayList<>(Arrays.asList(str)));
            }
        }
        return strMap.values().stream().collect(Collectors.toList());
    }

    private String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /**
     * 128. 最长连续序列
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        int result = 0;
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int num : nums) {
            if (hashSet.contains(num - 1)) {
                continue;
            }
            int length = 0;
            while (hashSet.contains(num++)) {
                length++;
            }
            result = Math.max(length, result);
        }
        return result;
    }
}
