package io.kaitoshy.rpcfx.demo.provider.resolver;

import io.kaitoshy.rpcfx.server.RpcfxResolver;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class DemoResolver implements ApplicationContextAware, RpcfxResolver {
    private ApplicationContext cxt;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.cxt = ctx;
    }

    @Override
    public Object resolve(String serviceClass) {
        return this.cxt.getBean(serviceClass);
    }
}
