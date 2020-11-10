import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author kaito
 * @createDate 2020/11/10 22:44
 */
public class FutureDemo {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        });

        new Thread(task).start();

        int result = 0;
        try {
            result = task.get(); //这是得到的返回值
        } catch (ExecutionException|InterruptedException e) {
            e.printStackTrace();
        }

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
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
