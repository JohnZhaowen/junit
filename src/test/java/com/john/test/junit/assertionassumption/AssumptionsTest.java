package com.john.test.junit.assertionassumption;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@Slf4j
@SpringBootTest
@ActiveProfiles("test")
public class AssumptionsTest {

    @Value("${envType}")
    private String envType;

    @Test
    @DisplayName("assume用法")
    public void tryAssumeTrue() {
        assumeTrue("CI".equals(envType));
        log.info("CI环境才会打印的assumeTrue");
    }

    @Test
    @DisplayName("assume失败时带自定义错误信息")
    public void tryAssumeTrueWithMessage() {
        // 第二个入参是Supplier实现，返回的内容用作跳过用例时的提示信息
        assumeTrue("CI".equals(envType), () -> "环境不匹配而跳过，当前环境：" + envType);

        log.info("CI环境才会打印的tryAssumeTrueWithMessage");
    }

    @Test
    @DisplayName("assume成功时执行指定逻辑")
    public void tryAssumingThat() {
        // 第二个入参是Executable实现，
        // 当第一个参数为true时，执行第二个参数的execute方法
        assumingThat("CI".equals(envType), () -> log.info("这一行内容只有在CI环境才会打印"));

        log.info("无论什么环境都会打印的tryAssumingThat");
    }

}
