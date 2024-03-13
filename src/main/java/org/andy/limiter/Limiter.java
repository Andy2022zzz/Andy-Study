package org.andy.limiter;

/**
 * @author: Andy
 * @createTime: 2024-03-14 00:24
 * @description: interface
 */
public interface Limiter {

    boolean tryAcquire();
}
