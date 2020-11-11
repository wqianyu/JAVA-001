import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kaito
 * @createDate 2020/11/11 11:39
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) throws InterruptedException {

        final CyclicBarrier barrier = new CyclicBarrier(1);

        long start = System.currentTimeMillis();

        SumaryFibo fibo = new SumaryFibo(barrier);
        fibo.start();

        Thread.sleep(100);

        System.out.println("异步计算结果为："+ fibo.getResult());

        System.out.println("使用时间："+ (System.currentTimeMillis() - start) + " ms");


    }

    static class SumaryFibo extends Thread{
        private CyclicBarrier cyclicBarrier;
        private AtomicInteger result = new AtomicInteger();

        public SumaryFibo(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在执行...");
            try {
                result.set(Fibo.sum());
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("计算结果：" + result.get());
        }

        public Integer getResult() {
            System.out.println("===>result：" + result.get());
            return this.result.get();
        }
    }
}

