import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kaito
 * @createDate 2020/11/11 11:08
 */
public class CountDownLatchDemo {
    private final static int threadCount = 200;

    public static void main(String[] args) {
        AtomicInteger result = new AtomicInteger();

        BlockingQueue  workQueue = new LinkedBlockingQueue<>(200);
        ExecutorService exec = new ThreadPoolExecutor(4, 8,
                500, TimeUnit.MILLISECONDS, workQueue);

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        long start = System.currentTimeMillis();

        exec.execute(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getName());
            result.set(Fibo.sum());
            countDownLatch.countDown();
        });

        try {
            countDownLatch.await();

            System.out.println("异步计算结果为："+ result);

            System.out.println("使用时间："+ (System.currentTimeMillis() - start) + " ms");
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            exec.shutdown(); // 线程池不会把线程干掉的
        }

    }


}
