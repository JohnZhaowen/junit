package com.john.test.junit.parameterized.method_source;

import com.john.test.junit.model.Account;
import com.john.test.junit.service.AccountQuerySericeImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.stream.Stream;

@Slf4j
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@ActiveProfiles("test")
public class MethodSourceTest {

    @Autowired
    private AccountQuerySericeImpl accountQuerySerice;

    @DisplayName("静态方法返回集合，用此集合中每个元素作为入参")
    @ParameterizedTest
    @MethodSource("stringProvider")
    @RepeatedTest(5)
    public void testMethodSource(String candidate) {
        log.info("methodSourceTest [{}]", candidate);
    }

    /**
     * 1. 方法必须是static类型
     * 2. 返回值必须是Stream类型     *
     *
     * @return
     */
    private static Stream<String> stringProvider() {
        return Stream.of("apple", "banana");
    }


    @DisplayName("testInstance注解")
    @ParameterizedTest(name = "序号 [{index}]，产品信息 [{0}]")
    @MethodSource("accountProvider")
    public void testMethodSource1(Account account) {
        log.info("methodSourceTest [{}]", account);
    }

    /**
     * 非静态方法，类上必须加注解@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
     *
     * @return
     */
    private Stream<Account> accountProvider() {
        return accountQuerySerice.queryAll().stream();
    }

}
