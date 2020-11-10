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
                return sum();
            }
        });

        int sum = 0;
        try {
            sum = result.get(); //这是得到的返回值
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+ sum);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
        executor.shutdownNow();
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }
}
