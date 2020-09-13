package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTypeTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void string() {
        redisTemplate.opsForValue().set("num", 123);
        redisTemplate.opsForValue().set("string", "some strings");
        Object s = redisTemplate.opsForValue().get("num");
        Object s2 = redisTemplate.opsForValue().get("string");
        System.out.println(s);
        System.out.println(s2);
    }

    @Test
    public void string2() {
        redisTemplate.opsForValue().set("num", "123XYZ", 3, TimeUnit.SECONDS);
        try {
            Object s = redisTemplate.opsForValue().get("num");
            System.out.println(s);
            Thread.currentThread().sleep(2000);
            Object s2 = redisTemplate.opsForValue().get("num");
            System.out.println(s2);
            Thread.currentThread().sleep(5000);
            Object s3 = redisTemplate.opsForValue().get("num");
            System.out.println(s3);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    @Test
    public void string3() {
        redisTemplate.opsForValue().set("key", "helloworld", 1);
        System.out.println(redisTemplate.opsForValue().get("key", 2, 11).toString());
    }

    @Test
    public void string4() {
        redisTemplate.opsForValue().set("getSetTest", "test");
        System.out.println(redisTemplate.opsForValue().getAndSet("getSetTest", "test2"));
        System.out.println(redisTemplate.opsForValue().get("getSetTest"));
    }

    @Test
    public void string5() {
        redisTemplate.opsForValue().append("k", "123");
        redisTemplate.opsForValue().append("k", "456");
        //query redis-cli:
        //        127.0.0.1:6379> get k
        //        "123456"
    }

    @Test
    public void string6() {
        redisTemplate.opsForValue().set("key", "1");
        System.out.println(redisTemplate.opsForValue().size("key"));
    }

    @Test
    public void hash1() {
        Map<String, Object> testMap = new HashMap();
        testMap.put("name", "Song");
        testMap.put("sex", "male");
        redisTemplate.opsForHash().putAll("Hash", testMap);
        System.out.println(redisTemplate.opsForHash().entries("Hash"));
//        127.0.0.1:6379> HGETALL Hash
//        1) "sex"
//        2) "male"
//        3) "name"
//        4) "Song"
    }

    @Test
    public void hash2() {
        redisTemplate.opsForHash().put("redisHash", "name", "Song");
        redisTemplate.opsForHash().put("redisHash", "sex", "male");
        System.out.println(redisTemplate.opsForHash().entries("redisHash"));
        System.out.println(redisTemplate.opsForHash().values("redisHash"));
    }

    @Test
    public void hash3() {
        redisTemplate.opsForHash().put("redisHash", "name", "Song");
        redisTemplate.opsForHash().put("redisHash", "sex", "male");
        System.out.println(redisTemplate.opsForHash().delete("redisHash", "name"));
        System.out.println(redisTemplate.opsForHash().entries("redisHash"));
//        127.0.0.1:6379> HGETALL redisHash
//        1) "sex"
//        2) "male"
    }

    @Test
    public void hash4() {
        redisTemplate.opsForHash().put("redisHash", "name", "Song");
        redisTemplate.opsForHash().put("redisHash", "sex", "male");
        System.out.println(redisTemplate.opsForHash().hasKey("redisHash", "name"));
        System.out.println(redisTemplate.opsForHash().hasKey("redisHash", "age"));
    }

    @Test
    public void hash7() {
        redisTemplate.opsForHash().put("redisHash", "name", "Song");
        redisTemplate.opsForHash().put("redisHash", "sex", "male");
        System.out.println(redisTemplate.opsForHash().get("redisHash", "name"));
    }

    @Test
    public void hash8() {
        redisTemplate.opsForHash().put("redisHash", "name", "Song");
        redisTemplate.opsForHash().put("redisHash", "sex", "male");
        System.out.println(redisTemplate.opsForHash().keys("redisHash"));
    }

    @Test
    public void hash9() {
        redisTemplate.opsForHash().put("redisHash", "name", "Song");
        redisTemplate.opsForHash().put("redisHash", "sex", "male");
        System.out.println(redisTemplate.opsForHash().size("redisHash"));
    }

    @Test
    public void list1() {
        String[] strings = new String[]{"1", "2", "3"};
        redisTemplate.opsForList().leftPushAll("list", strings);
        System.out.println(redisTemplate.opsForList().range("list", 0, -1));
//        127.0.0.1:6379> LRANGE list 0 2
//        1) "\"3\""
//        2) "\"2\""
//        3) "\"1\""
    }

    @Test
    public void list2() {
        String[] strings = new String[]{"1", "2", "3"};
        redisTemplate.opsForList().leftPushAll("list", strings);
        System.out.println(redisTemplate.opsForList().size("list"));
    }

    @Test
    public void list3() {
        //127.0.0.1:6379> del list
        redisTemplate.opsForList().leftPush("list", "1");
        System.out.println(redisTemplate.opsForList().size("list"));
        redisTemplate.opsForList().leftPush("list", "2");
        System.out.println(redisTemplate.opsForList().size("list"));
        redisTemplate.opsForList().leftPush("list", "3");
        System.out.println(redisTemplate.opsForList().size("list"));
    }

    @Test
    public void list4() {
        redisTemplate.opsForList().rightPush("listRight", "1");
        System.out.println(redisTemplate.opsForList().size("listRight"));
        redisTemplate.opsForList().rightPush("listRight", "2");
        System.out.println(redisTemplate.opsForList().size("listRight"));
        redisTemplate.opsForList().rightPush("listRight", "3");
        System.out.println(redisTemplate.opsForList().size("listRight"));
//        127.0.0.1:6379> LRANGE listRight 0 10
//        1) "\"1\""
//        2) "\"2\""
//        3) "\"3\""
    }

    @Test
    public void list5() {
        String[] strings = new String[]{"1", "2", "3"};
        redisTemplate.opsForList().rightPushAll("list", strings);
        System.out.println(redisTemplate.opsForList().range("list", 0, -1));
//        127.0.0.1:6379> LRANGE list 0 10
//        1) "\"1\""
//        2) "\"2\""
//        3) "\"3\""
    }

    @Test
    public void list6() {
        String[] strings = new String[]{"1", "2", "3"};
        redisTemplate.opsForList().rightPushAll("list6", strings);
        System.out.println(redisTemplate.opsForList().range("list6", 0, -1));
        redisTemplate.opsForList().set("list6", 1, "值");
        System.out.println(redisTemplate.opsForList().range("list6", 0, -1));
//        127.0.0.1:6379> LRANGE list6 0 -1
//        1) "\"1\""
//        2) "\"\xe5\x80\xbc\""
//        3) "\"3\""
    }

    @Test
    public void list7() {
        String[] strings = new String[]{"1", "2", "3"};
        redisTemplate.opsForList().rightPushAll("list7", strings);
        System.out.println(redisTemplate.opsForList().range("list7", 0, -1));
        redisTemplate.opsForList().remove("list7", 1, "2");
        System.out.println(redisTemplate.opsForList().range("list7", 0, -1));
    }

    @Test
    public void list8() {
        String[] strings = new String[]{"1", "2", "3"};
        redisTemplate.opsForList().rightPushAll("list8", strings);
        System.out.println(redisTemplate.opsForList().range("list8", 0, -1));
        System.out.println(redisTemplate.opsForList().index("list8", 2));
    }

    @Test
    public void list9() {
        String[] strings = new String[]{"1", "2", "3"};
        redisTemplate.opsForList().rightPushAll("list9", strings);
        System.out.println(redisTemplate.opsForList().range("list9", 0, -1));
        System.out.println(redisTemplate.opsForList().leftPop("list9"));
        System.out.println(redisTemplate.opsForList().range("list9", 0, -1));
    }

    @Test
    public void list10() {
        String[] strings = new String[]{"1", "2", "3"};
        redisTemplate.opsForList().rightPushAll("list10", strings);
        System.out.println(redisTemplate.opsForList().range("list10", 0, -1));
        System.out.println(redisTemplate.opsForList().rightPop("list10"));
        System.out.println(redisTemplate.opsForList().range("list10", 0, -1));
    }

    @Test
    public void Set1() {
        String[] strs = new String[]{"str1", "str2"};
        System.out.println(redisTemplate.opsForSet().add("Set1", strs));
        System.out.println(redisTemplate.opsForSet().add("Set1", "1", "2", "3"));
//        127.0.0.1:6379> SMEMBERS Set1
//        1) "\"str2\""
//        2) "\"2\""
//        3) "\"1\""
//        4) "\"str1\""
//        5) "\"3\""
    }

    @Test
    public void Set2() {
        String[] strs = new String[]{"str1", "str2"};
        System.out.println(redisTemplate.opsForSet().add("Set2", strs));
        System.out.println(redisTemplate.opsForSet().remove("Set2", strs));
    }

    @Test
    public void Set3() {
        String[] strs = new String[]{"str1", "str2"};
        System.out.println(redisTemplate.opsForSet().add("Set3", strs));
        System.out.println(redisTemplate.opsForSet().pop("Set3"));
        System.out.println(redisTemplate.opsForSet().members("Set3"));
//        127.0.0.1:6379> SMEMBERS Set3
//        1) "\"str1\""
    }

    @Test
    public void Set4() {
        String[] strs = new String[]{"str1", "str2"};
        System.out.println(redisTemplate.opsForSet().add("Set4", strs));
        redisTemplate.opsForSet().move("Set4", "str2", "Set4to2");
        System.out.println(redisTemplate.opsForSet().members("Set4"));
        System.out.println(redisTemplate.opsForSet().members("Set4to2"));
//        127.0.0.1:6379> SMEMBERS Set4
//        1) "\"str1\""
//        127.0.0.1:6379> SMEMBERS Set4to2
//        1) "\"str2\""
    }

    @Test
    public void Set5() {
        String[] strs = new String[]{"str1", "str2"};
        System.out.println(redisTemplate.opsForSet().add("Set5", strs));
        System.out.println(redisTemplate.opsForSet().size("Set5"));
    }

    @Test
    public void Set6() {
        String[] strs = new String[]{"str1", "str2"};
        System.out.println(redisTemplate.opsForSet().add("Set6", strs));
        System.out.println(redisTemplate.opsForSet().members("Set6"));
    }

    @Test
    public void Set7() {
        String[] strs = new String[]{"str1", "str2"};
        System.out.println(redisTemplate.opsForSet().add("Set7", strs));
        Cursor<Object> curosr = redisTemplate.opsForSet().scan("Set7", ScanOptions.NONE);
        while (curosr.hasNext()) {
            System.out.println(curosr.next());
        }
    }

    @Test
    public void Zset1() {
        ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>("zset-1", 9.6);
        ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>("zset-2", 9.9);
        Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<ZSetOperations.TypedTuple<Object>>();
        tuples.add(objectTypedTuple1);
        tuples.add(objectTypedTuple2);
        System.out.println(redisTemplate.opsForZSet().add("zset1", tuples));
        System.out.println(redisTemplate.opsForZSet().range("zset1", 0, -1));
    }

    @Test
    public void Zset2() {
        System.out.println(redisTemplate.opsForZSet().add("zset2", "zset-1", 1.0));
        System.out.println(redisTemplate.opsForZSet().add("zset2", "zset-1", 1.0));
    }

    @Test
    public void Zset3() {
        System.out.println(redisTemplate.opsForZSet().add("zset3", "zset-1", 1.0));
        System.out.println(redisTemplate.opsForZSet().add("zset3", "zset-2", 1.0));
        System.out.println(redisTemplate.opsForZSet().range("zset3", 0, -1));
        System.out.println(redisTemplate.opsForZSet().remove("zset3", "zset-2"));
        System.out.println(redisTemplate.opsForZSet().range("zset3", 0, -1));
    }

    @Test
    public void Zset4() {
        System.out.println(redisTemplate.opsForZSet().add("zset4", "zset-1", 1.0));
        System.out.println(redisTemplate.opsForZSet().add("zset4", "zset-2", 0.5));
        System.out.println(redisTemplate.opsForZSet().range("zset4", 0, -1));
        System.out.println(redisTemplate.opsForZSet().rank("zset4", "zset-1"));
    }

    @Test
    public void Zset5() {
        ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>("zset-1", 9.6);
        ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>("zset-2", 9.1);
        Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<ZSetOperations.TypedTuple<Object>>();
        tuples.add(objectTypedTuple1);
        tuples.add(objectTypedTuple2);
        System.out.println(redisTemplate.opsForZSet().add("zset5", tuples));
        System.out.println(redisTemplate.opsForZSet().range("zset5", 0, -1));
    }

    @Test
    public void Zset6() {
        ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>("zset-1", 3.6);
        ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>("zset-2", 4.1);
        ZSetOperations.TypedTuple<Object> objectTypedTuple3 = new DefaultTypedTuple<>("zset-3", 5.7);
        Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<ZSetOperations.TypedTuple<Object>>();
        tuples.add(objectTypedTuple1);
        tuples.add(objectTypedTuple2);
        tuples.add(objectTypedTuple3);
        System.out.println(redisTemplate.opsForZSet().add("zset6", tuples));
        System.out.println(redisTemplate.opsForZSet().rangeByScore("zset6", 0, 9));
        System.out.println(redisTemplate.opsForZSet().count("zset6", 0, 5));
    }

    @Test
    public void Zset7() {
        ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>("zset-1", 3.6);
        ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>("zset-2", 4.1);
        ZSetOperations.TypedTuple<Object> objectTypedTuple3 = new DefaultTypedTuple<>("zset-3", 5.7);
        Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<ZSetOperations.TypedTuple<Object>>();
        tuples.add(objectTypedTuple1);
        tuples.add(objectTypedTuple2);
        tuples.add(objectTypedTuple3);
        System.out.println(redisTemplate.opsForZSet().add("zset7", tuples));
        System.out.println(redisTemplate.opsForZSet().size("zset7"));
    }

    @Test
    public void Zset8() {
        ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>("zset-1", 3.6);
        ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>("zset-2", 4.1);
        ZSetOperations.TypedTuple<Object> objectTypedTuple3 = new DefaultTypedTuple<>("zset-3", 5.7);
        Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<ZSetOperations.TypedTuple<Object>>();
        tuples.add(objectTypedTuple1);
        tuples.add(objectTypedTuple2);
        tuples.add(objectTypedTuple3);
        System.out.println(redisTemplate.opsForZSet().add("zset8", tuples));
        System.out.println(redisTemplate.opsForZSet().score("zset8", "zset-3"));
    }

    @Test
    public void Zset9() {
        ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>("zset-1", 3.6);
        ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>("zset-2", 5.1);
        ZSetOperations.TypedTuple<Object> objectTypedTuple3 = new DefaultTypedTuple<>("zset-3", 2.7);
        Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<ZSetOperations.TypedTuple<Object>>();
        tuples.add(objectTypedTuple1);
        tuples.add(objectTypedTuple2);
        tuples.add(objectTypedTuple3);
        System.out.println(redisTemplate.opsForZSet().add("zset9", tuples));
        System.out.println(redisTemplate.opsForZSet().range("zset9", 0, -1));
        System.out.println(redisTemplate.opsForZSet().removeRange("zset9", 1, 2));
        System.out.println(redisTemplate.opsForZSet().range("zset9", 0, -1));
    }

    @Test
    public void Zset10() {
        ZSetOperations.TypedTuple<Object> objectTypedTuple1 = new DefaultTypedTuple<>("zset-1", 3.6);
        ZSetOperations.TypedTuple<Object> objectTypedTuple2 = new DefaultTypedTuple<>("zset-2", 5.1);
        ZSetOperations.TypedTuple<Object> objectTypedTuple3 = new DefaultTypedTuple<>("zset-3", 2.7);
        Set<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<ZSetOperations.TypedTuple<Object>>();
        tuples.add(objectTypedTuple1);
        tuples.add(objectTypedTuple2);
        tuples.add(objectTypedTuple3);
        System.out.println(redisTemplate.opsForZSet().add("zset10", tuples));
        Cursor<ZSetOperations.TypedTuple<Object>> cursor = redisTemplate.opsForZSet().scan("zset10", ScanOptions.NONE);
        while (cursor.hasNext()) {
            ZSetOperations.TypedTuple<Object> item = cursor.next();
            System.out.println(item.getValue() + ":" + item.getScore());
        }
    }

    @Test
    public void Zsetdss() {
        Integer count = 10;
        Integer i;
        for (i=0; i < count; i++) {
            redisTemplate.opsForList().leftPush("slist", i);
        }
        System.out.println(redisTemplate.opsForList().range("slist", 0, -1));
//        127.0.0.1:6379> LRANGE slist 0 -1
//        1) "9"
//        2) "8"
//        3) "7"
//        4) "6"
//        5) "5"
//        6) "4"
//        7) "3"
//        8) "2"
//        9) "1"
//        10) "0"
    }

    @Test
    public void s2() {
        if (redisTemplate.opsForList().size("slist") > 0) {
            long user_id = 1903;
            redisTemplate.opsForList().leftPush("ulist", user_id);
        }
        System.out.println(redisTemplate.opsForList().range("slist", 0, -1));
        System.out.println(redisTemplate.opsForList().range("ulist", 0, -1));
//        127.0.0.1:6379> LRANGE ulist 0 -1
//        1) "1903"
    }
}