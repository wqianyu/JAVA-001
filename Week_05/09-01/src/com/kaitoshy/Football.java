package com.kaitoshy;

/**
 * @author kaito
 * @createDate 2020/11/16 23:13
 */
public class Football implements Ball{
    @Override
    public void play(Integer personNum) {
        System.out.println(personNum + "个人在玩足球");
    }
}
