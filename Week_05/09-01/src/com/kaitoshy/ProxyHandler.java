package com.kaitoshy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author kaito
 * @createDate 2020/11/16 23:23
 */
public class ProxyHandler implements InvocationHandler {
    private Object object;

    public ProxyHandler(Object obj) {
        this.object = obj;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = null;
        System.out.println("aop--------before->"+method.getName());
        ret = method.invoke(object, args);
        System.out.println("aop--------after->"+method.getName());
        return ret;
    }
}
