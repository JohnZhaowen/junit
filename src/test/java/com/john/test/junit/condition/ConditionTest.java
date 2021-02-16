package com.john.test.junit.condition;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ConditionTest {

    @Test
    @Order(100)
    @EnabledOnOs(OS.WINDOWS)
    @DisplayName("操作系统：只有windows才会执行")
    public void onlyWindowsTest() {
        assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @Order(2)
    @EnabledOnOs({OS.WINDOWS, OS.LINUX})
    @DisplayName("操作系统：windows和linux都会执行")
    public void windowsORLinuxTest() {
        assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @Order(3)
    @DisabledOnOs({OS.WINDOWS})
    @DisplayName("操作系统：WINDOWS系统不会执行")
    public void withoutMacTest() {
        assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @Order(4)
    @EnabledOnJre({JRE.JAVA_9, JRE.JAVA_11})
    @DisplayName("Java环境：只有JAVA9和11版本才会执行")
    public void onlyJava9And11Test() {
        assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @Order(5)
    @DisabledOnJre({JRE.JAVA_8})
    @DisplayName("Java环境：JAVA8不执行")
    public void withoutJava9Test() {
        assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @Order(6)
    @EnabledForJreRange(min=JRE.JAVA_8, max=JRE.JAVA_11) @DisplayName("Java环境：从JAVA8到1之间的版本都会执行")

    public void fromJava8To11Test() {
        assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @Order(7)
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    @DisplayName("系统属性：64位操作系统才会执行")
    public void only64BitArch() {
        assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @Order(8)
    @DisabledIfSystemProperty(named = "java.vm.name", matches = ".*HotSpot.*")
    @DisplayName("系统属性：HotSpot不会执行")
    public void withOutHotSpotTest() {
        assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @Order(9)
    @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*")
    @DisplayName("环境变量：JAVA_HOME才会执行")
    public void onlyJavaHomeExistsInEnvTest() {
        assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @Order(10)
    @DisabledIfEnvironmentVariable(named = "GOPATH", matches = ".*")
    @DisplayName("环境变量：有GOPATH就不执行")
    public void withoutGoPathTest() {
        assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @Order(11)
    @EnabledIf("customCondition")
    @DisplayName("自定义：customCondition返回true就执行")
    public void onlyCustomConditionTest() {
        assertEquals(2, Math.addExact(1, 1));
    }

    @Test
    @Order(12)
    @DisabledIf("customCondition")
    @DisplayName("自定义：customCondition返回true就不执行")
    public void withoutCustomConditionTest() {
        assertEquals(2, Math.addExact(1, 1));
    }

    private boolean customCondition() {
        return true;
    }

}
