package com.john.test.junit.service;

public interface HelloService {

    /**
     * 拼接给定的字符串
     * @param name
     * @return
     */
    String hello(String name);

    /**
     * 将给定的数据加1
     * @param value
     * @return
     */
    int increase(int value);

    /**
     * 远程服务调用
     * @return
     */
    boolean remoteRequest();
}
