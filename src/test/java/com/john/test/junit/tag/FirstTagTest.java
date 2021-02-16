package com.john.test.junit.tag;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@Tag("first")
public class FirstTagTest {

    @Test
    @Tag("easy")
    @Tag("important")
    @DisplayName("first-1")
    void first1Test() {
        log.info("first1Test");
        assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @Tag("easy")
    @DisplayName("first-2")
    void first2Test() {
        log.info("first2Test");
        assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @Tag("hard")
    @DisplayName("first-3")
    void first3Test() {
        log.info("first3Test");
        assertEquals(2, Math.addExact(1, 1));
    }
}