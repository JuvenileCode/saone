package com.bademo.redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by:redis 连接测试
 * //http://www.cnblogs.com/liuling/p/2014-4-19-04.html
 * @author Bin.l
 * @date 2017/7/24 22:54
 */
public class RedisJoinTest{
    private Jedis jedis;

    @Before
    public void setup() {
        //连接redis服务器，ip:6379
        jedis = new Jedis("127.0.0.1", 6379);
        //权限认证
        //jedis.auth("admin");
    }

    /**
     * redis 存储字符串
     */
    @Test
    public void testString() {
        jedis.set("name", "xinxin");//向key-->name中放入了value-->xinxin
        System.out.println(jedis.get("name"));

        jedis.append("name", " is my lover"); //拼接
        System.out.println(jedis.get("name"));

        jedis.del("name"); //删除某个键
        System.out.println(jedis.get("name"));

        jedis.mset("name", "liuling", "age", "23", "qq", "476777XXX");//设置多个键值对
        jedis.incr("age"); //进行加1操作
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
    }

    /**
     * redis操作Map
     */
    @Test
    public void testMap(){
        //-----添加数据----------//
        Map<String, String> map = new HashMap<String, String>();
        map.put("name","haoren");
        map.put("age","22");
        map.put("qq","123456789");
        jedis.hmset("user",map);
        //取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List

    }
}
