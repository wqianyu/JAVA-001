import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author kaito
 * @createDate 2020/11/10 22:27
 */
public class ForkJoin {
    public static void main(String[] args) {
        //
        long start = System.currentTimeMillis();

        //创建分治任务线程池
        ForkJoinPool fjp = new ForkJoinPool(10);
        //创建分治任务
        Fibonacci fib = new Fibonacci(36);
        //启动分治任务
        Integer result = fjp.invoke(fib);
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis() - start) + " ms");
    }
}

/**
 * 斐波拉切计算
 *
 * @author kaito
 */
class Fibonacci extends RecursiveTask<Integer> {
    final int n;

    Fibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }
        // 这个耗时特别长
        //System.out.println("线程：" + Thread.currentThread());

        Fibonacci f1 = new Fibonacci(n - 1);
        //创建子任务
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        //等待子任务结果，并合并结果
        return f2.compute() + f1.join();
    }
}
