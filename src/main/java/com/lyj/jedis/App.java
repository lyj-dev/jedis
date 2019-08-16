package com.lyj.jedis;

import com.lyj.utils.JedisUtil;
import redis.clients.jedis.Jedis;

public class App {
    public static void main(String[] args) {
        // 创建Jedis对象
        Jedis jedis = JedisUtil.getJedis();
        // 设置连接密码
        jedis.auth("123456");

        // g恩据key值获取字符串内容
        //String name = jedis.get("name");

        //System.out.println(name);

        // 设置值
//        jedis.set("hobby", "打游戏");
//        System.out.println(jedis.get("hobby"));

        // 获取hash结构中的value值
        String hname = jedis.hget("hh", "name");
        System.out.println(hname);

        // 关闭
        jedis.close();

        jedisPoolTest();
    }

    public static void jedisPoolTest() {
        Jedis jedis = JedisUtil.getJedis();
        System.out.println(jedis.get("name"));

        JedisUtil.closeJedis(jedis);
    }
}
