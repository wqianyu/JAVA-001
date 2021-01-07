package io.kaitoshy.redis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.UUID;

/**
 * @author kaitoShy
 */
@Slf4j
public class RedisDistributedLock implements DistributedLock{
    @Resource
    private JedisPool jedisPool;

    private static final String LOCK_SUCCESS = "OK";
    private static final Long RELEASE_SUCCESS = 1L;
    private static final int SECONDS_TO_EXPIRE = 3;

    @Override
    public String acquire(String lockKey) {
        try(Jedis jedis = jedisPool.getResource()) {
            String requireToken = UUID.randomUUID().toString();
            SetParams params = new SetParams();
            params.nx().ex(SECONDS_TO_EXPIRE);
            if (LOCK_SUCCESS.equals(jedis.set(lockKey, requireToken, params))) {
                return requireToken;
            }
        }

        return "";
    }

    @Override
    public boolean release(String lockKey, String identify) {
        String luaScript = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
        try (Jedis jedis = jedisPool.getResource()){
            return jedis.eval(luaScript, Collections.singletonList(lockKey), Collections.singletonList(identify)).equals(RELEASE_SUCCESS);
        }
    }
}
