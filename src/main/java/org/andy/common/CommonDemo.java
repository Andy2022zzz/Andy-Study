package org.andy.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Andy
 * @createTime: 2024-03-10 19:08
 * @description: class
 */
public class CommonDemo {
    public static void main(String[] args) {
        System.out.println("begin");
        List<myTest> myTestList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            myTestList.add(new myTest("hello" + i));
        }
        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("over");
    }

    static class myTest {
        private String str;

        public myTest(String str) {
            this.str = str;
        }
    }
}
