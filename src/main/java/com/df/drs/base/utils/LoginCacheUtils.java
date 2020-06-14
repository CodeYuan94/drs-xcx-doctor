package com.df.drs.base.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author yuan
 * @project drs
 * @description guava本地缓存工具类
 * @date 2020/5/28 11:43
 **/
public class LoginCacheUtils {
    /**
     * token对应用户key
     */
    public static final String TOKEN_KEY = "user_id";

    private static CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
            //设置缓存最大容量为1000，超过1000之后就会按照LRU最近虽少使用算法来移除缓存项
            .maximumSize(1000)
            //设置并发级别为8，并发级别是指可以同时写缓存的线程数
            .concurrencyLevel(8)
            //设置缓存容器的初始容量为1
            .initialCapacity(1)
            //设置写缓存后30天过期
            .expireAfterWrite(30, TimeUnit.DAYS);
    private static Cache<String, Object> cache;

    static{
        cache =cacheBuilder.build();
    }

    /**
     * 添加缓存
     * @param key
     * @param value
     */
    public static void set(String key, Object value){
        try{
            cache.put(key, value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 删除缓存
     * @param key
     */
    public static void del(String key){
        cache.invalidate(key);
    }

    /**
     * 根据key取得缓存对象
     * @param key
     * @return
     */
    public static Object get(String key){
        try{
            return cache.getIfPresent(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取指定类型数据
     * @param key 键值
     * @param clazz 指定类型
     * @param <T>
     * @return
     */
    public static<T> T get(String key,Class<T> clazz){
        Object obj = get(key);
        return  null != obj ? clazz.cast(obj) : null;
    }

    /**
     * 获取字符串
     * @param key
     * @return
     */
    public static String getStr(String key){
        Object obj = get(key);
        return null != obj ? obj.toString() : null;
    }

    /**
     * 清除所有缓存
     */
    public static void clearAll(){
        cache.cleanUp();
    }

    /**
     * 获取长整型
     * @param key
     * @return
     */
    public static Long getLong(String key){
        Object value = get(key);
        if(null == value){
            return null;
        }
        if(value instanceof Long){
            return Long.valueOf(value.toString());
        }
        return null;
    }

    public static BigDecimal getBigDecimal(String key){
        Object value = get(key);
        if(value instanceof BigDecimal){
            return new BigDecimal(value.toString());
        }
        return BigDecimal.ZERO;
    }

    public static void main(String[] arg){
        String authorization = UUID.randomUUID().toString().replaceAll("-","");
        set(authorization,"111");
    }
}
