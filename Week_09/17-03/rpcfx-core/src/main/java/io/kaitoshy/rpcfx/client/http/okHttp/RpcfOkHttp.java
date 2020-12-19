package io.kaitoshy.rpcfx.client.http.okHttp;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import io.kaitoshy.rpcfx.dto.RpcFxRequest;
import io.kaitoshy.rpcfx.dto.RpcFxResponse;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

public final class RpcfOkHttp {

    static {
        ParserConfig.getGlobalInstance().addAccept("io.kaitoshy");
    }


    public static final MediaType JSONTYPE = MediaType.get("application/json; charset=utf-8");

    public RpcFxResponse post(RpcFxRequest req, String url) throws IOException {
        String reqJson = JSON.toJSONString(req);
        System.out.println("req json: "+reqJson);

            // 1.可以复用client
            // 2.尝试使用httpclient或者netty client
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSONTYPE, reqJson))
                .build();
        String respJson = client.newCall(request).execute().body().string();
        System.out.println("resp json: "+respJson);
        return JSON.parseObject(respJson, RpcFxResponse.class);
    }
}
