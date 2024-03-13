package org.andy.common;

import lombok.AllArgsConstructor;
import org.andy.utils.CommonUtil;

/**
 * @author: Andy
 * @createTime: 2024-03-11 19:40
 * @description: class
 */
public class DeadLockDemo {

    @AllArgsConstructor
    static class Inventory {
        private String count;
    }

    public static void main(String[] args) {
        Inventory inventory1 = new Inventory("100");
        Inventory inventory2 = new Inventory("200");

        new Thread(() -> {
            synchronized (inventory1) {
                System.out.println("Thread 1: Holding inventory1");
                CommonUtil.sleep(100);
                System.out.println("Thread 1: Waiting for inventory2");
                synchronized (inventory2) {
                    System.out.println("Thread 1: Holding inventory1 and inventory2");
                }
            }
        }).start();


        new Thread(() -> {
            synchronized (inventory2) {
                System.out.println("Thread 2: Holding inventory2");
                CommonUtil.sleep(100);
                System.out.println("Thread 2: Waiting for inventory1");
                synchronized (inventory1) {
                    System.out.println("Thread 2: Holding inventory2 and inventory1");
                }
            }
        }).start();
    }
}
