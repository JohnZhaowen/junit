package com.john.test.junit.assertionassumption;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * Assumptions如果失败则抛出TestAbortedException异常，测试被跳过，不标记为测试失败
 * Assertions如果失败则抛出AssertionFailedError异常，测试不通过
 */
@Slf4j
public class AssumptionsAndAssetionsTest {

    /**
     * assumeTrue不抛出异常的用例
     */
    @Test
    void assumeSuccess() {
        // assumeTrue方法的入参如果为true，就不会抛出异常，后面的代码才会继续执行
        assumeTrue(true);
        // 如果打印出此日志，证明assumeTrue方法没有抛出异常
        log.info("assumpSuccess的assumeTrue执行完成");
        // 接下来是常规的单元测试逻辑
        assertEquals(2, Math.addExact(1,1));
    }

    /**
     * assumeTrue抛出异常的用例
     */
    @Test
    void assumeFail() {
        // assumeTrue方法的入参如果为false，就会抛出TestAbortedException异常，后面就不会执行了
        assumeTrue(false, "未通过assumeTrue");
        // 如果打印出此日志，证明assumpFail方法没有抛出异常
        log.info("assumpFail的assumeTrue执行完成");
        // 接下来是常规的单元测试逻辑，但因为前面抛出了异常，就不再执行了
        assertEquals(2, Math.addExact(1,1));
    }

    /**
     * 最简单的成功用例
     */
    @Test
    void assertSuccess() {
        assertEquals(2, Math.addExact(1,1));
    }

    /**
     * 最简单的失败用例
     */
    @Test
    void assertFail() {
        assertEquals(3, Math.addExact(1,1));
    }

}
