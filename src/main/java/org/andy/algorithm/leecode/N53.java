package org.andy.algorithm.leecode;

/**
 * @author: Andy
 * @createTime: 2024-03-17 23:36
 * @description: 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 */
public class N53 {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 0; i < length; i++) {
            // 每个位置对应子数组的最大值是 当前值 或者 上一个位置子数组的最大值+当前值
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
