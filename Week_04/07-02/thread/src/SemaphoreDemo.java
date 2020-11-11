import java.util.concurrent.Semaphore;

/**
 * @author kaito
 * @createDate 2020/11/11 13:41
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5); //机器数目

        long start = System.currentTimeMillis();

        Worker worker = new Worker(1, semaphore);
        worker.start();

        try {
            Thread.sleep(100);
            // 确保  拿到result 并输出
            System.out.println("异步计算结果为：" + worker.getResult());

            System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;
        private int result;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();  // 在子线程里控制资源占用
                result = Fibo.sum();
                semaphore.release();   // 在子线程里控制释放资源占用
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public Integer getResult() {
            return this.result;
        }
    }
}
