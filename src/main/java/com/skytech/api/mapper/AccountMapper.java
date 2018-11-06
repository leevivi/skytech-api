package com.skytech.api.mapper;

import com.skytech.api.model.Account;
import com.skytech.api.model.AccountExample;
import com.owthree.core.mapper.GenericMapper;
import org.springframework.stereotype.Component;

@Component
public interface AccountMapper extends GenericMapper<Account, AccountExample, String> {
}