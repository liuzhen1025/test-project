/**
 * copyRight
 */
package com.gennlife;

import org.redisson.Redisson;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.stereotype.Component;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/11/26
 * Time: 10:14
 */
//@Component
public class RedisHelper {
    private static Config config ;
    private static RedissonClient redisson;
    static {
        config = new Config();
        config.useSingleServer()
                .setAddress("redis://10.0.2.92:6380")
                .setDatabase(0)
                .setConnectionMinimumIdleSize(2)
                .setConnectionPoolSize(10);
        redisson = Redisson.create(config);
    }
    public RedissonClient getRedison(){
        return redisson;
    }
    public void put(String redisonKey, String key, Object value){

        RMapCache<Object, Object> mapCache = redisson.getMapCache(redisonKey);
        mapCache.put(key, value);
    }
    public Object get(String redisonKey, String key){

        RMapCache<Object, Object> mapCache = redisson.getMapCache(redisonKey);
        return mapCache.get(key);
    }
}
