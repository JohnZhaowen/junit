package com.john.test.junit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private String accountId;

    private String accountName;

    private Integer benchmark;

    private Integer hasPosition;
}
