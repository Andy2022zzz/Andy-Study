package org.andy.limiter;

/**
 * @author: Andy
 * @createTime: 2024-03-13 22:41
 * @description: 滑动窗口算法
 * 缺点: 还是存在限流不够平滑的问题
 */
public class SlidingWindowRateLimiter implements Limiter{

    // 时间窗口大小 单位:毫秒
    long windowsSize;

    // 分片窗口数
    int shardNum;

    // 允许通过的请求数
    int maxRequestCount;

    // 各个窗口内的请求计数
    int[] shardRequestCount;

    // 请求总数
    int totalCount;

    // 当前窗口下标
    int shardId;

    // 每个窗口大小 毫秒
    long tinyWindowsSize;

    // 窗口右边界
    long windowBroder;

    public SlidingWindowRateLimiter(long windowsSize, int shardNum, int maxRequestCount) {
        this.windowsSize = windowsSize;
        this.shardNum = shardNum;
        this.maxRequestCount = maxRequestCount;
        this.shardRequestCount = new int[shardNum];
        this.tinyWindowsSize = windowsSize / shardNum;
        this.windowBroder = System.currentTimeMillis();
    }

    public synchronized boolean tryAcquire() {
        long currentTime = System.currentTimeMillis();
        if (windowBroder < currentTime) {
            do {
                // 当前时间超过右边界时 移动到下一个分块 将下一个分块数据清空
                shardId = (++shardId) % shardNum;
                totalCount -= shardRequestCount[shardId];
                shardRequestCount[shardId] = 0;
                windowBroder += tinyWindowsSize;
            } while (windowBroder < currentTime);
        }
        if (totalCount < maxRequestCount) {
            shardRequestCount[shardId]++;
            totalCount++;
            return true;
        } else {
            return false;
        }
    }
}
