package com.gennlife.lock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.params.SetParams;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author liuzhen278
 * @title: DisLock
 * @projectName mytest-project
 * @description: TODO
 * @date 2019/7/910:35
 */
public class DisLock implements Lock {

    private Jedis jedis;
    private JedisCluster jedisCluster;
    private String key;
    public DisLock(String key){
        this.key = key;
    }
    @Override
    public void lock() {
        SetParams params = new SetParams();
        params.nx().px(10000);
        jedisCluster.set(key,Thread.currentThread().getId()+"",params);
    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public Condition newCondition() {
        return null;
    }

}
