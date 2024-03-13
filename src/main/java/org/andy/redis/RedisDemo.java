package org.andy.redis;

import lombok.SneakyThrows;
import redis.clients.jedis.Jedis;

/**
 * @author: Andy
 * @createTime: 2024-03-11 11:35
 * @description: class
 */
public class RedisDemo {

    private static volatile int total = 10000;

    @SneakyThrows
    private static void sleep(long millis) {
        Thread.sleep(millis);
    }

    public static void main(String[] args) {
        Jedis initial = new Jedis("localhost");
        initial.set("inventory","10000");
        initial.del("userMap");
        initial.hset("userMap", "userid","status");
        System.out.println("初始库存：" + initial.get("inventory"));

        String script = "local current = redis.call('get', KEYS[1])\n" +
                "local decrement = tonumber(ARGV[1])\n" +
                "if current and tonumber(current) >= decrement then\n" +
                "\tredis.call('hset', KEYS[2], ARGV[2], ARGV[3])\n" +
                "\treturn redis.call('decrby', KEYS[1], decrement)\n" +
                "else\n" +
                "\treturn -1\n" +
                "end";

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Jedis jedis = new Jedis("localhost");
                while (total-- > 0) {
                    String userid = "user" + total;
                    jedis.eval(script, 2, "inventory", "userMap", String.valueOf(1), userid, "received");
                    System.out.println(userid + " " + jedis.hget("userMap", userid));
                    System.out.println(Thread.currentThread().getName()+ " 库存剩余：" + jedis.get("inventory"));
                }
                jedis.close();
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String result = initial.get("inventory");
        System.out.println("最终库存剩余: "+ result);
        initial.close();
    }
}
