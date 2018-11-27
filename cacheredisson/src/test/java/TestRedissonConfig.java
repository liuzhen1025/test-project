/**
 * copyRight
 */


import org.junit.BeforeClass;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.client.codec.BaseCodec;
import org.redisson.client.codec.Codec;
import org.redisson.client.protocol.Decoder;
import org.redisson.client.protocol.Encoder;
import org.redisson.cluster.ClusterConnectionManager;
import org.redisson.codec.CompositeCodec;
import org.redisson.codec.FstCodec;
import org.redisson.codec.SerializationCodec;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/11/12
 * Time: 18:34
 */

public class TestRedissonConfig {
    private static Config config;
    private static RedissonClient redisson;
    @BeforeClass
    public static void beforeClass(){
        config = new Config();
        /*config.useClusterServers()
                .setScanInterval(2000)
                // 集群状态扫描间隔时间，单位是毫秒
                //可以用"rediss://"来启用SSL连接
                .addNodeAddress("redis://10.0.2.184:7001");*/
        config.useSingleServer()
                .setAddress("redis://10.0.2.92:6380")
                .setDatabase(0)
                .setConnectionMinimumIdleSize(2)
                .setConnectionPoolSize(10);
        redisson = Redisson.create(config);
        /*config.useMasterSlaveServers()
                .setMasterAddress("redis://10.0.5.89:7001")
                .addSlaveAddress("redis://10.0.5.89:7004", "redis://10.0.5.89:7005","redis://10.0.5.89:7006");*/
    }
    @Test
    public void lockTest()  throws Exception{
        System.out.println("-=------");
        try {

            String lockKey = String.valueOf("lockss");
            RLock lock = redisson.getLock(lockKey);
            RMapCache<Object, Object> cache = redisson.getMapCache("cache");
            boolean b1 = lock.tryLock(101l, 201l, TimeUnit.SECONDS);
            boolean b2 = lock.tryLock(100, 20, TimeUnit.SECONDS);
            System.out.println(b1+"\t"+b2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testAutomic(){
        RAtomicLong atomicLog = redisson.getAtomicLong("atomicLog");
        long l = atomicLog.getAndIncrement();
        long andAdd = atomicLog.getAndAdd(2);
        long l1 = atomicLog.get();
        boolean delete = atomicLog.delete();
        System.out.println(l+"\t"+andAdd+"\t"+l1);
    }
    @Test
    public void testSemaphore() throws Exception{

        RSemaphore semaphore = redisson.getSemaphore("semaphore5");
        //semaphore.reducePermits(5);
        //semaphore.trySetPermits(10);
        semaphore.release(10);
        //semaphore.trySetPermits(10);
        int i2 = semaphore.availablePermits();
        semaphore.acquire(2);
        semaphore.acquire(2);
        int i = semaphore.availablePermits();
        System.out.println(i);
        semaphore.acquire(6);
        int i1 = semaphore.availablePermits();
        System.out.println(i1);
    }
}
