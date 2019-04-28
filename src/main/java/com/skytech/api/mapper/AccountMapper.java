package com.skytech.api.mapper;

import com.skytech.api.model.Account;
import com.skytech.api.model.AccountExample;
import com.skytech.api.core.mapper.GenericMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Component;

@Component
public interface AccountMapper extends GenericMapper<Account, AccountExample, String> {
    public Account findAccountByEmail(@Param("email") String email);
}