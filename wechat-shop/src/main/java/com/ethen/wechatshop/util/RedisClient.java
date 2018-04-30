package com.ethen.wechatshop.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 单机版redis访问操作 todo 待封装 待优化
 */
public class RedisClient {

    public static final int DEFAULT_EXPIRE = 7200;

    /**
     *
     * 设置过期时间   seconds
     * @param key
     * @param value
     * @param expire
     */
    public void set(String key,String value, Integer expire){
        set(key,value);
        if (expire == null || expire < 0 ){
            expire(key,DEFAULT_EXPIRE);
        }
        expire(key,expire);
    }

    //获取指定 key 的值。如果 key 不存在，返回 nil
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.get(key);
        jedis.close();
        return string;
    }

    //设置一些字符串值
    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.set(key, value);
        jedis.close();
        return string;
    }

    //获取哈希表中指定字段的值
    public String hget(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.hget(hkey, key);
        jedis.close();
        return string;
    }

    //为哈希表中的字段赋值
    public long hset(String hkey, String key, String value) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.hset(hkey, key, value);
        jedis.close();
        return result;
    }


    //将 key 中储存的数字值增一,如果 key 不存在，那么 key 的值会先被初始化为 0 ，然后再执行INCR操作
    public long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.incr(key);
        jedis.close();
        return result;
    }

    //设置key的到期时间
    public long expire(String key, int second) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.expire(key, second);
        jedis.close();
        return result;
    }

    //以秒为单位返回 key 的剩余过期时间
    public long ttl(String key) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.ttl(key);
        jedis.close();
        return result;
    }

    //根据key删除
    public long del(String key) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.del(key);
        jedis.close();
        return result;
    }

    //删除哈希表key中的一个或多个指定字段
    public long hdel(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.hdel(hkey, key);
        jedis.close();
        return result;
    }



    private JedisPool jedisPool;

    public RedisClient() {
    }

    public RedisClient(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }



    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
}
