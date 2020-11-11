/**
 * @author kaito
 * @createDate 2020/11/11 10:41
 */
public class Fibo {

    public static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }
}
