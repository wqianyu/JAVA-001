import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author kaito
 * @createDate 2020/10/17 09:44
 */
public class HelloClassLoader extends ClassLoader{
    private final static String PATH_NAME = "./02-ClassLoader/src/Hello.xlass";

    public static void main(String[] args) {
        try {
            Class<?> clz = new HelloClassLoader().findClass("Hello");
            Object o = clz.newInstance();
            Method m = clz.getMethod("hello");
            m.invoke(o);
        } catch (ClassNotFoundException | IllegalAccessException
                | InstantiationException | NoSuchMethodException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] rawBytes = new byte[0];
        try {
            rawBytes = getBytesFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] decodeBytes = decodeBytes(rawBytes);

        return defineClass(name, decodeBytes, 0, decodeBytes.length);
    }

    private byte[] getBytesFromFile() throws FileNotFoundException {
        File f = new File(PATH_NAME);
        if (!f.exists()) {
            throw new FileNotFoundException(PATH_NAME);
        }
        int fileLength = (int)f.length();
        byte[] bytes = new byte[fileLength];

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
             ByteArrayOutputStream bos = new ByteArrayOutputStream(fileLength)
        ){
            int bufSize = 1024;
            byte[] buffer = new byte[bufSize];
            int len;
            while (-1 != (len = in.read(buffer, 0, bufSize))) {
                bos.write(buffer, 0, len);
            }
            bytes = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bytes;
    }

    private byte[] decodeBytes(byte[] rawBytes) {
        int byteCapacity = rawBytes.length;
        byte[] decodeBytes = new byte[byteCapacity];
        for (int i = 0;  i < rawBytes.length; i++) {
            decodeBytes[i] = (byte)(255 - rawBytes[i]);
        }
        return decodeBytes;
    }


}
