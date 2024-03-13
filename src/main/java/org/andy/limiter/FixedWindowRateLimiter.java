package org.andy.limiter;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Andy
 * @createTime: 2024-03-13 20:04
 * @description: 固定窗口算法
 * 缺点：限流不够平滑、无法处理窗口边界问题
 */
@Data
public class FixedWindowRateLimiter {

    // 时间窗口大小 单位: 毫秒
    long windowSize;

    // 允许通过的请求数
    int maxRequestCount;

    // 当前窗口通过的请求数
    AtomicInteger counter = new AtomicInteger(0);

    // 窗口右边界
    long windowBorder;

    public FixedWindowRateLimiter(long windowSize, int maxRequestCount) {
        this.windowSize = windowSize;
        this.maxRequestCount = maxRequestCount;
        this.windowBorder = System.currentTimeMillis() + windowSize;
    }

    public synchronized boolean tryAcquire() {
        long currentTime = System.currentTimeMillis();
        if (windowBorder < currentTime) {
            // 如果当前时间已经超过窗口右边界 也就是已经超过当前窗口 需要移动到下一个窗口
            do {
                windowBorder += windowSize;
            } while (windowBorder < currentTime);
            counter = new AtomicInteger(0);
        }
        // 此时已进行窗口内 判断当前窗口内的请求数是否已到最大请求数
        if (counter.intValue() < maxRequestCount) {
            counter.incrementAndGet();
            return true;
        } else {
            return false;
        }
    }
}
