package io.kaitoshy.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
@Slf4j
public class RedisApplication implements CommandLineRunner {
    private final static String LOCK_KEY = "redis_lock_key";
    private static int amount = 100;

    @Resource
    private RedisDistributedLock lock;

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       Runnable task = () -> {
           String token = lock.acquire(LOCK_KEY);
           if ("".equals(token)) {
               log.error(">==== get lock failed!");
               return;
           } else {
               log.info(">===== get lock success!, random token:{}", token);
           }
           amount -= 1;
           log.info(">======{} is Running, amount now is {}", Thread.currentThread().getName(), amount);

           boolean releaseFlag = lock.release(LOCK_KEY, token);
           log.info(">=== release lock end, {}", releaseFlag);
       };

       for (int i = 0; i < 10; i++) {
           Thread t = new Thread(task);
           t.start();
          // t.join();
       }

        Thread t = new Thread(task);
        t.start();
        Thread t2 = new Thread(task);
        t2.start();
        t2.join();
        t.join();
    }
}
