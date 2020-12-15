package io.kaitoshy.rpcfx.client.http.netty;


import com.alibaba.fastjson.JSON;
import io.kaitoshy.rpcfx.dto.RpcFxRequest;
import io.kaitoshy.rpcfx.dto.RpcFxResponse;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.IOException;

public class RpcfxNettyClient {

    public static <T> T create(final Class<T> serviceClass, final String url) {
       // return  invoke()
        return null;
    }

    private <T> T invoke(Class<T> serviceClass, final String url) throws Throwable {
        RpcFxRequest request = new RpcFxRequest();
        request.setServiceClass(serviceClass.getName());

        RpcFxResponse response = post(request, url);

        // 这里判断response.status，处理异常
        // 考虑封装一个全局的RpcfxException
        return (T)JSON.parse(response.getResult().toString());
    }

    private RpcFxResponse post(RpcFxRequest req, String url) throws IOException {
        String reqJson = JSON.toJSONString(req);
        System.out.println("req json: "+reqJson);

        // 1.可以复用client
        // 2.尝试使用httpclient或者netty client
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
//        try {
//            Bootstrap b = new Bootstrap();
//            b.group(group)
//                    .channel(NioSocketChannel.class)
//                    .handler(new HttpSnoopClientInitializer());
//
//            // Make the connection attempt.
//            Channel ch = b.connect(host, port).sync().channel();
//
//            // Prepare the HTTP request.
//            HttpRequest request = new DefaultFullHttpRequest(
//                    HttpVersion.HTTP_1_1, HttpMethod.GET, uri.getRawPath(), Unpooled.EMPTY_BUFFER);
//            request.headers().set(HttpHeaderNames.HOST, host);
//            request.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.CLOSE);
//            request.headers().set(HttpHeaderNames.ACCEPT_ENCODING, HttpHeaderValues.GZIP);
//
//            // Set some example cookies.
//            request.headers().set(
//                    HttpHeaderNames.COOKIE,
//                    ClientCookieEncoder.STRICT.encode(
//                            new DefaultCookie("my-cookie", "foo"),
//                            new DefaultCookie("another-cookie", "bar")));
//
//            // Send the HTTP request.
//            ch.writeAndFlush(request);
//
//            // Wait for the server to close the connection.
//            ch.closeFuture().sync();
//        } finally {
//            // Shut down executor threads to exit.
//            group.shutdownGracefully();
//        }

          return null;
    }
}
