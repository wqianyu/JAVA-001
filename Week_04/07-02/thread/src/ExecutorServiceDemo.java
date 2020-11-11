import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author kaito
 * @createDate 2020/11/11 10:40
 */
public class ExecutorServiceDemo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(16);

        try {
            Integer sum = executorService.submit(Fibo::sum).get();

            // 确保  拿到result 并输出
            System.out.println("异步计算结果为："+ sum);

            System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }


}
