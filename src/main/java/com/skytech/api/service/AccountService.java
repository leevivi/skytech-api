package com.skytech.api.service;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.skytech.api.model.Account;
import com.skytech.api.model.AccountExample;
import com.owthree.core.service.GenericService;

public interface AccountService extends GenericService<Account, String> {

    Pagination<Account> findForPage(int page, int limit);

    JsonMap save(Account account);

    JsonMap update(String accountSid, Account account);

    JsonMap delete(String... accountSids);
}


