package com.skytech.api.service;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.owthree.core.service.GenericService;
import com.skytech.api.model.Account;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface AccountService extends GenericService<Account, String> {

    Pagination<Account> findForPage(int page, int limit);

    Map<String, Object> register(String email, String password, String firstName, String lastName);

    Account login(String email, String password);

    JsonMap saveProfile(String accountSid, Account account, MultipartFile picFile);

    JsonMap save(Account account);

    JsonMap update(String accountSid, Account account);

    JsonMap delete(String... accountSids);

    JsonMap saveAvatar(String accountSid,MultipartFile picFile);
}


