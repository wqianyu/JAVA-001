import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kaito
 * @createDate 2020/11/11 10:24
 */
public class RunableDemo {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger fiboSum = new AtomicInteger(0);

        long start = System.currentTimeMillis();

        Thread thread = new Thread(() -> {
            fiboSum.set(Fibo.sum());
        });

        thread.start();
        thread.join();

        int result = fiboSum.get(); //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }
}
