package com.john.test.junit.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "Hello " + name;
    }

    @Override
    public int increase(int value) {
        return value + 1;
    }

    /**
     * 模拟远程调用，睡眠1s
     * @return
     */
    @Override
    public boolean remoteRequest() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        return true;
    }
}
