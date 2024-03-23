package org.andy.algorithm.leecode;

/**
 * @author: Andy
 * @createTime: 2024-03-16 19:13
 * @description: 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class N283 {

    public void moveZeroes(int[] nums) {
        int j = 0;
        // i j 两个指针，i 遍历整个数组，j 指向下一个非零元素的位置
        // 如果 nums[i] 不为 0，则与 nums[j] 交换，并将 j 加一
        // 最终，nums[i] 中的元素都是非零元素，nums[j:] 中的元素都是 0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        // 将 nums[j:] 中的元素都设置为 0
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}
