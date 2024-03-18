package org.andy.algorithm.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Andy
 * @createTime: 2024-03-16 19:49
 * @description: 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 */
public class N15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // 遍历整个数组，从后面找到两个和nums[k]相加为0的数
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) continue; // nums[k]已经大于0了，后面的两个数更大
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while (i > j && nums[j] == nums[--j]);
                } else {
                    // 如果相加为0则加入到结果中，左右指针分别移动去重
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }

}
