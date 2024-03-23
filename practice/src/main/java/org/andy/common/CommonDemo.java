package org.andy.common;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Andy
 * @createTime: 2024-03-10 19:08
 * @description: class
 */
public class CommonDemo {

    @Test
    public void test() {
        test2();
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

    public void test2() {
        List<String> list = new ArrayList<>(Collections.singletonList("11"));
        list.add("22");
    }

}
