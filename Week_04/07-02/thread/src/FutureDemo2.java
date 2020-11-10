import java.util.concurrent.*;

/**
 * @author kaito
 * @createDate 2020/11/10 22:55
 */
public class FutureDemo2 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        System.out.println("当前线程：" + Thread.currentThread().getName());
        // 线程池单线程
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //ExecutorService executor = Executors.newFixedThreadPool(16);
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("当前线程：" + Thread.currentThread().getName());
                return sum();
            }
        });
        executor.submit(task);

        int result = 0;
        try {
            //这是得到的返回值
            result = task.get();
        } catch (ExecutionException |InterruptedException e) {
            e.printStackTrace();
        }

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
        executor.shutdown();
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
