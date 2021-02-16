package com.john.test.junit.concurrent_running;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Slf4j
public class ConcurrentRunningTest {

    @Execution(ExecutionMode.SAME_THREAD)
    @DisplayName("单线程执行10次")
    @RepeatedTest(value = 10, name="完成度：{currentRepetition}/{totalRepetitions}")
    public void sameThreadTest(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        log.info("测试方法 [{}]，当前第[{}]次，共[{}]次",
                testInfo.getTestMethod().get().getName(),
                repetitionInfo.getCurrentRepetition(),
                repetitionInfo.getTotalRepetitions());
    }

    @Execution(ExecutionMode.CONCURRENT)
    @DisplayName("多线程执行10次")
    @RepeatedTest(value = 10, name="完成度：{currentRepetition}/{totalRepetitions}")
    public void concurrentTest(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        log.info("测试方法 [{}]，当前第[{}]次，共[{}]次",
                testInfo.getTestMethod().get().getName(),
                repetitionInfo.getCurrentRepetition(),
                repetitionInfo.getTotalRepetitions());
    }

    @Execution(ExecutionMode.CONCURRENT)
    @DisplayName("多个int型入参")
    @ParameterizedTest
    @ValueSource(ints = { 1,2,3,4,5,6,7,8,9,0 })
    public void intsTest(int candidate) {
        log.info("ints [{}]", candidate);
    }
}
