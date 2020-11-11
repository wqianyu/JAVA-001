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
                return Fibo.sum();
            }
        });

        new Thread(task).start();

        try {
            int result = task.get(); //这是得到的返回值
            // 确保  拿到result 并输出
            System.out.println("异步计算结果为："+result);

            System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        } catch (ExecutionException|InterruptedException e) {
            e.printStackTrace();
        }
    }
}
