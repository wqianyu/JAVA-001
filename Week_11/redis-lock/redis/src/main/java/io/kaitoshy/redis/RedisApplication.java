package io.kaitoshy.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RedisApplication implements CommandLineRunner {
    private final static String LOCK_KEY = "redis_lock_key";
    private static int amount = 100;

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       Runnable task = () -> {
           RedisDistributedLock lock = new RedisDistributedLock();
           String token = lock.acquire(LOCK_KEY);
           if ("".equals(token)) {
               log.error("获取锁失败！");
           }

           log.info(">======{} is Running", Thread.currentThread().getName());

           amount -= 1;

           boolean releaseFlag = lock.release(LOCK_KEY, token);
           log.info(">=== release lock end, {}", releaseFlag);
       };

       for (int i = 0; i < 10; i++) {
           Thread t = new Thread(task);
           t.start();
       }
    }
}
