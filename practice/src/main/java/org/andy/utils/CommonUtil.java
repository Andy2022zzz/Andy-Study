package org.andy.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

/**
 * @author: Andy
 * @createTime: 2024-03-11 19:41
 * @description: class
 */
@UtilityClass
public class CommonUtil {

    @SneakyThrows
    public void sleep(long millions) {
        Thread.sleep(millions);
    }
}
