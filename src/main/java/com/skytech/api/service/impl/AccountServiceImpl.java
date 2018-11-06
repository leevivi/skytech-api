package com.skytech.api.service.impl;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.model.Account;
import com.skytech.api.model.AccountExample;
import com.skytech.api.model.base.BaseAccountExample;
import com.skytech.api.service.AccountService;
import com.owthree.core.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("accountService")
public class AccountServiceImpl extends GenericServiceImpl<Account, AccountExample, String> implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    protected AccountMapper getGenericMapper() {
        return this.accountMapper;
    }

    @Override
    public Pagination<Account> findForPage(int page, int limit) {
        AccountExample accountExample = new AccountExample();
        BaseAccountExample.Criteria criteria = accountExample.createCriteria();

        Pagination<Account> pagination = this.queryByPage(accountExample, (page - 1) * limit, limit, "create_datetime desc");

        return pagination;
    }

    @Override
    public JsonMap save(Account account) {

        AccountExample accountExample = new AccountExample();

        List<Account> accounts = accountMapper.selectByExample(accountExample);

        account.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
        account.setCreateDatetime(new Date());
        int i = accountMapper.insertSelective(account);
        if (i > 0) {
            return JsonMap.of(true, "保存成功");
        } else {
            return JsonMap.of(false, "保存失败");
        }
    }

    @Override
    public JsonMap update(String accountSid, Account account) {
        account.setSid(accountSid);
        int i = accountMapper.updateByPrimaryKeySelective(account);
        if (i > 0) {
            return JsonMap.of(true, "修改成功");
        } else {
            return JsonMap.of(false, "修改失败");
        }
    }

    @Override
    public JsonMap delete(String... accountSids) {

        try {
            for (int i = 0; i < accountSids.length; i++) {
                Account account = new Account();

                account.setSid(accountSids[i]);

                accountMapper.updateByPrimaryKeySelective(account);

            }
        } catch (Exception e) {
            return JsonMap.of(false, "删除失败");
        }
        return JsonMap.of(true, "删除成功");
    }
}