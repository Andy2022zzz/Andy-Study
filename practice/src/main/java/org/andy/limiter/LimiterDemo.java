package org.andy.limiter;

import org.andy.utils.CommonUtil;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Andy
 * @createTime: 2024-03-13 20:03
 * @description: class
 * 常见的四种限流算法，分别是：固定窗口算法、滑动窗口算法、漏桶算法、令牌桶算法。
 */
public class LimiterDemo {

    @Test
    public void FixedWindowRateLimiterTest() {
        // 这是一个窗口大小为200ms 每个窗口只允许三个请求通过的限流器 相当于每67ms一个请求
        FixedWindowRateLimiter fixedWindowRateLimiter = new FixedWindowRateLimiter(200, 3);
        limit(fixedWindowRateLimiter);
        // 这是一个窗口大小为500ms 分为5个切片 每个窗口只允许5个请求通过的限流器 相当于每100ms一个请求
        SlidingWindowRateLimiter slidingWindowRateLimiter = new SlidingWindowRateLimiter(500, 5, 5);
        limit(slidingWindowRateLimiter);
        CommonUtil.sleep(30000);
    }

    private void limit(Limiter limiter) {
        AtomicInteger total = new AtomicInteger(100);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (total.intValue() >= 0) {
                    CommonUtil.sleep(100);
                    if (limiter.tryAcquire()) {
                        total.decrementAndGet();
                        System.out.println(Thread.currentThread().getName() + " 没有限流");
                    } else {
                        System.out.println(Thread.currentThread().getName() + " 触发限流");
                    }
                }
            }).start();
        }
    }
}
