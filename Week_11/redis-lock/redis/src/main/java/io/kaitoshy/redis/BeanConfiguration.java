package io.kaitoshy.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;

/**
 * @author kaitoShy
 */
@Configuration
@Slf4j
public class BeanConfiguration {
    @Bean
    @ConfigurationProperties("redis")
    public JedisPoolConfig jedisPoolConfig() {
        return new JedisPoolConfig();
    }

    @Bean(destroyMethod = "close")
    @Resource
    public JedisPool jedisPool(@Value("${redis.host}") String host) {
        log.info(">====config:{}", jedisPoolConfig());
        return new JedisPool(jedisPoolConfig(), host);
    }


}
