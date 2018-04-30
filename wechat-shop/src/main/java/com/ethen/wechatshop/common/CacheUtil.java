package com.ethen.wechatshop.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 单机系统下模拟缓存
 * @author ethen
 * @since 2018-04-22
 *
 * fixme 接入redis之后废弃
 * todo 待实现缓存过期机制...?
 */
public class CacheUtil {

    /**
     * 缓存容器
     */
    private static Map<String, Item> cacheMap = new HashMap<>();


    /**
     * 不设置过期时间
     *
     * @param key
     * @param value
     */
    public static void put(String key, Object value) {
        put(key, value, null, null);
    }


    /**
     * 设置过期时间
     *
     * @param key
     * @param value
     * @param expires
     */
    public static void put(String key, Object value, Long expires) {
        Long now = System.currentTimeMillis();
        put(key, value, now, expires);
    }


    /**
     * 根据key获取缓存的值,若过期或者异常，返回<code>null</code>
     *
     * @param key
     * @param <T>
     * @return
     */
    public static  <T> T get(String key) {
        Item item = cacheMap.get(key);
        try {
            if (item != null) {
                Object data = item.getData();
                if (data != null) {
                    return (T) data;
                }
            }
        } catch (Exception e) {
            //do something
        }
        return null;

    }

    private static void put(String key, Object value, Long startTime, Long expires) {
        Item item = new Item(value);
        if (startTime != null) {
            item.setStartTime(startTime);
        }
        if (expires != null) {
            item.setExpires(expires);
        }
        cacheMap.put(key, item);
    }


    /**
     * 缓存对象
     */
    static class Item {
        private Object data;
        private long startTime;
        private long expires;

        public Item(Object data) {
            this.data = data;
        }

        public Item(Object data, long startTime, long expires) {
            this.data = data;
            this.startTime = startTime;
            this.expires = expires;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public long getExpires() {
            return expires;
        }

        public void setExpires(long expires) {
            this.expires = expires;
        }
    }
}
