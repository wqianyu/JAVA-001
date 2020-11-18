package com.kaitoshy;

import java.lang.reflect.Proxy;

/**
 * @author kaito
 * @createDate 2020/11/16 23:07
 */
public class Main {
    public static void main(String[] args) {
        Football football = new Football();
        Ball ball = (Ball) Proxy.newProxyInstance(football.getClass().getClassLoader(), football.getClass().getInterfaces(), new ProxyHandler(football));
        ball.play(7);
    }
}
