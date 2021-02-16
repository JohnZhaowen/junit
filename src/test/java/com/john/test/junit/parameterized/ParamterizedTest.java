package com.john.test.junit.parameterized;

import com.john.test.junit.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.provider.*;

@Slf4j
public class ParamterizedTest {

    @ParameterizedTest
    @ValueSource(strings = {"zhangsan", "lisi", "wangwu"})
    @NullSource
    @DisplayName("string的参数化测试")
    public void testString(String name) {
        log.info("execute hello to: " + name);
    }

    @ParameterizedTest
    @EnumSource(names = {"SMALL", "UNKNOWN"})
    @DisplayName("枚举参数化测试")
    public void testEnum(Types type) {
        log.info("enumSourceTest [{}]", type);
    }

    @DisplayName("CSV格式多条记录入参")
    @ParameterizedTest
    @CsvSource(value = {"lemon, 10", "apple, 11", "banana, 12", "NIL, 3"}, nullValues = "NIL")
    public void csvSourceTest(String fruit, int rank) {
        log.info("csvSourceTest, fruit [{}], rank [{}]", fruit, rank);
    }

    @DisplayName("CSV文件多条记录入参1")
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/two-column.csv", numLinesToSkip = 1)
    public void csvFileTest1(String accountId, String accountName, Integer benchmark, Integer hasPosition) {
        Account account = new Account(accountId, accountName, benchmark, hasPosition);
        log.info("account: ", account);
    }

    @DisplayName("CSV文件多条记录入参2-参数聚合")
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/two-column.csv", numLinesToSkip = 1)
    public void csvFileTest2(@AggregateWith(AccountAggregator.class) Account account) {
        System.out.println(account);
    }

}

class AccountAggregator implements ArgumentsAggregator {

    @Override
    public Object aggregateArguments(ArgumentsAccessor aa, ParameterContext pc) {
        Account account = new Account();
        account.setAccountId(aa.getString(0));
        account.setAccountName(aa.getString(1));
        account.setBenchmark(aa.getInteger(2));
        account.setHasPosition(aa.getInteger(3));
        return account;
    }
}

enum Types {
    SMALL,
    BIG,
    UNKNOWN
}
