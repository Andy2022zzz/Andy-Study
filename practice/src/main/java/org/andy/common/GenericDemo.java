package org.andy.common;

import lombok.Data;

/**
 * @author: Andy
 * @createTime: 2024-03-16 23:52
 * @description: 泛型class
 */
public class GenericDemo {

    @Data
    public class Entity<T,R> {

        T clazz1;
        R clazz2;

        public Entity(T clazz1, R clazz2) {
            this.clazz1 = clazz1;
            this.clazz2 = clazz2;
        }
    }

    @Data
    public class Request {
        private String userid;
    }

    @Data
    public class ChildRequest extends Request {
        private String password;
    }

    @Data
    public class Response {
        private String code;
    }

}
