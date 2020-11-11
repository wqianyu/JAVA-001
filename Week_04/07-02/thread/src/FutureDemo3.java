import java.util.Random;
import java.util.concurrent.*;

/**
 * @author kaito
 * @createDate 2020/11/10 23:08
 */
public class FutureDemo3 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> result = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return Fibo.sum();
            }
        });

        int sum = 0;
        try {
            sum = result.get(); //这是得到的返回值
            // 确保  拿到result 并输出
            System.out.println("异步计算结果为："+ sum);

            System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            // 然后退出main线程
            executor.shutdownNow();
        }
    }
}
