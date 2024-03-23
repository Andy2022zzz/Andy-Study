package org.andy.common;

/**
 * @author: Andy
 * @createTime: 2024-03-23 11:08
 * @description: class
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(findTarget(6, 0, nums.length - 1, nums));
    }

    private static int findTarget(int target, int begin, int end, int[] nums) {
        int k = (begin + end) / 2;
        if (begin > end) {
            return -1;
        }
        if (nums[begin] == target) {
            return begin;
        }
        if (nums[end] == target) {
            return end;
        }
        if (target == nums[k]) {
            return k;
        } else if (target < nums[k] && target > nums[begin]) {
            return findTarget(target, begin, k - 1, nums);
        } else {
            return findTarget(target, k, end, nums);
        }
    }

}
