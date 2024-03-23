package org.andy.algorithm.leecode;

/**
 * @author: Andy
 * @createTime: 2024-03-16 19:27
 * @description: 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 */
public class N11 {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, area = 0;
        // 双指针向中间移动，依次比较面积大小
        while (i < j) {
            if (height[i] < height[j]) {
                // j-i 需要协助 i++ 前面，不然i的值就变化了
                area = Math.max(area, (j - i) * height[i++]);
            } else {
                area = Math.max(area, (j - i) * height[j--]);
            }
        }
        return area;
    }
}
