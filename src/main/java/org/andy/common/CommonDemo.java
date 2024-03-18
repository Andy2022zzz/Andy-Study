package org.andy.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Andy
 * @createTime: 2024-03-10 19:08
 * @description: class
 */
public class CommonDemo {

    @Test
    public void test() {
        test1(new ArrayList<>(Arrays.asList(1,2)));
    }

    class testClass {
        private String code;
    }

    public List<?> test1(List<?> list) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            result.add((Integer) list.get(i) + 1);
        }
        return result;
    }

    public <T extends testClass> void test2() {

    }

}
