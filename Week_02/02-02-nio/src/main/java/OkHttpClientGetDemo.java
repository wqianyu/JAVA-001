import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.Objects;

/**
 * @author kaito
 * @createDate 2020/10/25 20:11
 */
public class OkHttpClientGetDemo {
    private static final String SERVER_URL = "http://localhost:8803";

    public static void main(String[] args) {
        try {
            String response = run(SERVER_URL);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        OkHttpClient client = new OkHttpClient();
        try (Response response = client.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }


}
