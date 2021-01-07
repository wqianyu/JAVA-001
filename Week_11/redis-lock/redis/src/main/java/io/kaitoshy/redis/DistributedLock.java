package io.kaitoshy.redis;

/**
 * @author kaitoShy
 */
public interface DistributedLock {
    String acquire(String lock);

    boolean release(String lockKey, String identify);
}
