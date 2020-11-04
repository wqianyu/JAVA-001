package io.github.kimmking.gateway.inbound;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import io.github.kimmking.gateway.filter.HttpRequestFilter;
import io.github.kimmking.gateway.filter.HttpRequestFilterImpl;
import io.github.kimmking.gateway.outbound.httpclient4.HttpOutboundHandler;
import io.github.kimmking.gateway.outbound.okhttp.OkHttpOutboundHandler;
import io.github.kimmking.gateway.router.HttpEndpointRouter;
import io.github.kimmking.gateway.router.HttpEndpointRouterImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.ReferenceCountUtil;
import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HttpInboundHandler extends ChannelInboundHandlerAdapter {
    private OkHttpOutboundHandler handler;
    private HttpRequestFilter filter;
    private HttpEndpointRouter router;
    private List<String> proxyServerList;
  //  private HttpOutboundHandler handler;
    
    public HttpInboundHandler(String proxyServer) {

        filter = new HttpRequestFilterImpl();
        proxyServerList = Splitter.on(",").splitToList(proxyServer);
        //handler = new HttpOutboundHandler(this.proxyServer);
        router = new HttpEndpointRouterImpl();
        handler = new OkHttpOutboundHandler();
    }
    
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            System.out.println("----*****----");
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            // 增加过滤器
            filter.filter(fullRequest, ctx);
            // 增加路由
            String proxyServer = router.route(proxyServerList);
            // 处理方法
            handler.handle(proxyServer, fullRequest, ctx);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
