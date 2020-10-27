/**
 * @author kaito
 * @createDate 2020/10/20 22:15
 */
public class Hello {
    private int privateInt = 200;

    public static void main(String[] args) {
        int a = 20000000;
        long b = 300000000L;


        System.out.println("a + b =" + (a + b));
        System.out.println("b / a =" + (b / a));
        System.out.println("b - a = " + (b - a));
        System.out.println("a * b = " + (a * b));

        boolean z = false;

        int c = 200;
        if (b > a) {
            c = -300;
        }

        float[] d = new float[10];
        for (int i = 0; i < 10; i++) {
            d[i] = 0.01F;
        }

        System.out.println("---this is split line---");

        for (float f:d) {
            System.out.println(f);
        }
    }




}
