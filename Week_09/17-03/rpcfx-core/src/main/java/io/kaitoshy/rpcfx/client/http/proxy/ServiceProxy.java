package io.kaitoshy.rpcfx.client.http.proxy;

import io.kaitoshy.rpcfx.client.Rpcfx;
import net.sf.cglib.proxy.Enhancer;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kaitoShy
 */
public class ServiceProxy implements Rpcfx {
    private final ConcurrentHashMap<String, Object> serviceMap = new ConcurrentHashMap<>();

    @Override
    public <T> T create(Class<T> clazz, String url) {
        if (!isExist(clazz.getName())) {
            addMap(clazz.getName(), newProxy(clazz, url));
        }

        return (T) getProxy(clazz.getName());
    }

    private Object newProxy(final Class<?> clazz, final String url) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new ServiceInterceptor(clazz, url));
        return enhancer.create();
    }

    private Object getProxy(final String serviceName) {
        return serviceMap.get(serviceName);
    }

    private Boolean isExist(final String serviceName) {
        return serviceMap.containsKey(serviceName);
    }

    private void addMap(final String serviceName, final Object clazz) {
        serviceMap.put(serviceName, clazz);
    }

}
