package org.andy.limiter;

/**
 * @author: Andy
 * @createTime: 2024-03-14 00:29
 * @description: class
 */
public class LeakyBucketRateLimiter implements Limiter{

    @Override
    public boolean tryAcquire() {
        return false;
    }
}
