package com.john.test.junit.nested_test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Slf4j
@DisplayName("嵌套测试")
public class NestedTest {

    @Nested
    @DisplayName("查找相关的测试")
    class FindService {

        @Test
        void findByIdTest() {

        }

        @Test
        void findByNameTest() {

        }

    }

    @Nested
    @DisplayName("删除相关的测试")
    class DeleteService {

        @Test
        void deleteByIdTest() {

        }

        @Test
        void deleteByNameTest() {

        }
    }

}
