package com.john.test.junit.basetest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class TimeoutAnnotationTest {

    @Test
    @Timeout(unit = TimeUnit.MILLISECONDS, value = 500)
    @DisplayName("测试Timeout注解")
    public void testTimeoutFail() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        log.info("执行到这里说明没有超时");
    }

    @Test
    @Timeout(unit = TimeUnit.SECONDS, value = 2)
    @DisplayName("测试Timeout注解")
    public void testTimeoutSuccess() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        log.info("执行到这里说明没有超时");
    }
}
