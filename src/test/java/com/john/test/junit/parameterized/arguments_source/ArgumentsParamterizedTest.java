package com.john.test.junit.parameterized.arguments_source;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.JavaTimeConversionPattern;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

@Slf4j
public class ArgumentsParamterizedTest {

    @DisplayName("ArgumentsProvider接口的实现类提供的数据作为入参")
    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    public void argumentsSourceTest(String candidate) {
        log.info("argumentsSourceTest [{}]", candidate);
    }

    @DisplayName("string型，指定转换器，转为LocalDate型入参")
    @ParameterizedTest
    @ValueSource(strings = { "01.01.2017", "31.12.2017" })
    public void argumentConversionWithConverterTest(
            @JavaTimeConversionPattern("dd.MM.yyyy") LocalDate candidate) {
        log.info("argumentConversionWithConverterTest [{}]", candidate);
    }
}
