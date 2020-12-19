package io.kaitoshy.rpcfx.client.http.proxy;

import com.alibaba.fastjson.JSON;
import io.kaitoshy.rpcfx.client.http.okHttp.RpcfOkHttp;
import io.kaitoshy.rpcfx.dto.RpcFxRequest;
import io.kaitoshy.rpcfx.dto.RpcFxResponse;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import okhttp3.MediaType;

import java.lang.reflect.Method;

/**
 * @author kaitoShy
 */
@Slf4j
public class ServiceInterceptor implements MethodInterceptor {
    private final Class<?> clazz;
    private final String url;
    public static final MediaType JSONTYPE = MediaType.get("application/json; charset=utf-8");

    public <T> ServiceInterceptor(final Class<T> clazz, final String url) {
        this.clazz = clazz;
        this.url = url;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        RpcFxRequest request = new RpcFxRequest();
        request.setServiceClass(clazz.getName());
        request.setMethod(method.getName());
        request.setParams(args);

        RpcfOkHttp okHttp = new RpcfOkHttp();
        RpcFxResponse response = okHttp.post(request, url);

        // 这里判断response.status，处理异常
        // 考虑封装一个全局的RpcfxException

        return JSON.parse(response.getResult().toString());
    }
}
