import java.util.concurrent.CompletableFuture;

/**
 * @author kaito
 * @createDate 2020/11/11 10:54
 */
public class ComletableFutureDemo {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Integer result = CompletableFuture.supplyAsync(Fibo::sum).join();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为："+ result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
