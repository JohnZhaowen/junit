package com.john.test.junit.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class HelloServiceImplTest {

    private static final String NAME = "Tom";

    @Autowired
    private HelloService helloService;

    /**
     * 在所有测试方法执行前被执行
     */
    @BeforeAll
    public static void beforeAll() {
        log.info("execute beforeAll");
    }

    /**
     * 在所有测试方法执行后被执行
     */
    @AfterAll
    public static void afterAll() {
        log.info("execute afterAll");
    }

    /**
     * 每个测试方法执行前都会执行一次
     */
    @BeforeEach
    public void beforeEach() {
        log.info("execute beforeEach");
    }

    /**
     * 每个测试方法执行后都会执行一次
     */
    @AfterEach
    public void afterEach() {
        log.info("execute afterEach");
    }

    @Test
    @DisplayName("测试service层的hello方法")
    public void testHello() {
        log.info("execute hello");
        assertThat(helloService.hello(NAME)).isEqualTo("Hello " + NAME);
    }

    /**
     * DisplayName中带有emoji，在测试框架中能够展示
     */
    @Test
    @DisplayName("测试service层的increase方法\uD83D\uDE31")
    public void testIncrease() {
        log.info("execute increase");
        assertThat(helloService.increase(1)).isEqualByComparingTo(2);
    }

    /**
     * 调用一个耗时1秒的方法，用Timeout设置超时时间是500毫秒，
     * 因此该用例会测试失败
     */
    @Test
    @Timeout(unit = TimeUnit.MILLISECONDS, value = 2000)
    @DisplayName("测试remoteRequest方法-不超时")
    public void testRemoteRequestNoOverTime() {
        assertThat(helloService.remoteRequest()).isEqualTo(true);
    }

    /**
     * 调用一个耗时1秒的方法，用Timeout设置超时时间是500毫秒，
     * 因此该用例会测试失败
     */
    @Test
    @Timeout(unit = TimeUnit.MILLISECONDS, value = 500)
    @DisplayName("测试remoteRequest方法-超时")
    public void testRemoteRequestOverTime() {
        assertThat(helloService.remoteRequest()).isEqualTo(true);
    }

}
