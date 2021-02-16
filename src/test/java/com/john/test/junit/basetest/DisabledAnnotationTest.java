package com.john.test.junit.basetest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class DisabledAnnotationTest {

    @Test
    @Disabled
    @DisplayName("Disabled注解标识不被执行的方法")
    public void disabledMethod() {
        log.info("disabledMethod");
    }

    @Test
    @DisplayName("会被执行的方法")
    public void executableMethod() {
        log.info("executableMethod");
    }
}
