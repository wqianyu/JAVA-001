package io.github.kimmking.gateway.outbound.okhttp;

import io.github.kimmking.gateway.outbound.httpclient4.NamedThreadFactory;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpUtil;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.*;

import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 *
 * @author kaito
 * @createTime 2020-11-03
 */
public class OkHttpOutboundHandler {
    private OkHttpClient client;

    public OkHttpOutboundHandler() {
        client =  new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .readTimeout(3, TimeUnit.SECONDS)
                .writeTimeout(3, TimeUnit.SECONDS)
                .build();
        System.out.println("client init finished!");
    }

    public void handle(final  String backendUrl, final FullHttpRequest fullRequest, final ChannelHandlerContext ctx) {
        final String url = backendUrl + fullRequest.uri();
        fetchGet(fullRequest, ctx, url);
    }

    private void fetchGet(final FullHttpRequest inbound, final ChannelHandlerContext ctx, final String url) {
        Headers.Builder headerBuilder = new Headers.Builder();

        for(Map.Entry<String, String> e : inbound.headers()) {
            headerBuilder.add(e.getKey(), e.getValue());
        }

        Headers okHttpClientHeaders =  headerBuilder.build();
        Request request = new Request.Builder().url(url).headers(okHttpClientHeaders).build();

        try (Response endpointResponse = client.newCall(request).execute()) {
            if (!endpointResponse.isSuccessful()) {
                throw new IOException("Unexpected code " + endpointResponse);
            }

            handleResponse(inbound, ctx, endpointResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void handleResponse(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx, final Response endpointResponse) throws Exception {
        FullHttpResponse response = null;
        try {

            ResponseBody responseBody = endpointResponse.body();

            response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(responseBody.bytes()));
            response.headers().set("Content-Type", "application/json");
            response.headers().setInt("Content-Length", Integer.parseInt(endpointResponse.header("Content-Length")));

        } catch (Exception e) {
            e.printStackTrace();
            response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
            exceptionCaught(ctx, e);
        } finally {
            if (fullRequest != null) {
                if (!HttpUtil.isKeepAlive(fullRequest)) {
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                } else {
                    ctx.write(response);
                }
            }
            ctx.flush();
            //  ctx.close();
        }
    }

    private void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
