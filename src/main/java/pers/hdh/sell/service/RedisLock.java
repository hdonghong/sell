package pers.hdh.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * RedisLock class<br/>
 * Redis分布式锁
 * @author hdonghong
 * @date 2018/04/13
 */
@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 采用!setnx加锁
     * @param key
     * @param value 有效期
     * @return
     */
    public boolean lock(String key, String value) {
        // 如果是第一次设置，则加锁成功
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }

        // 处理成功加锁却没有解锁的情况
        String currentValue = redisTemplate.opsForValue().get(key);
        // 如果超时，锁过期
        if (!StringUtils.isEmpty(currentValue)
                && System.currentTimeMillis() > Long.parseLong(currentValue)) {
            // 获取上一个锁的时间。
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
            // 可能会疑惑为什么还要获取，难道currentValue不就是上一个锁的时间吗？
            // 考虑多个线程同时执行到这里的情况。
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {
        String currentValue = redisTemplate.opsForValue().get(key);
        try {
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
