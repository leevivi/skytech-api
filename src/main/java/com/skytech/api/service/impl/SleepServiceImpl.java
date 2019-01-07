package com.skytech.api.service.impl;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.owthree.core.service.impl.GenericServiceImpl;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.mapper.SleepMapper;
import com.skytech.api.model.Account;
import com.skytech.api.model.Sleep;
import com.skytech.api.model.SleepExample;
import com.skytech.api.model.base.BaseSleepExample;
import com.skytech.api.service.SleepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("sleepService")
public class SleepServiceImpl extends GenericServiceImpl<Sleep, SleepExample, String> implements SleepService {

    @Autowired
    private SleepMapper sleepMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    protected SleepMapper getGenericMapper() {
        return this.sleepMapper;
    }

    @Override
    public Pagination<Sleep> findForPage(int page, int limit) {
        SleepExample sleepExample = new SleepExample();
        BaseSleepExample.Criteria criteria = sleepExample.createCriteria();

        Pagination<Sleep> pagination = this.queryByPage(sleepExample, (page - 1) * limit, limit, "created_datetime desc");

        return pagination;
    }

    @Override
    public JsonMap save(Sleep sleep) {
        Account account = accountMapper.selectByPrimaryKey(sleep.getAccountSid());
        sleep.setAccountName(account.getFirstName() + account.getLastName());
        SleepExample sleepExample = new SleepExample();

        sleepExample.createCriteria().andAccountSidEqualTo(sleep.getAccountSid()).andDeviceSidEqualTo(sleep.getDeviceSid()).andRecordDateEqualTo(sleep.getRecordDate());
        int i = 0;
        List<Sleep> sleeps = sleepMapper.selectByExample(sleepExample);
        if (sleeps.isEmpty()) {
            sleep.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
            sleep.setCreatedDatetime(new Date());
            i = sleepMapper.insertSelective(sleep);
        } else {
            Sleep one = sleeps.get(0);
            one.setCreatedDatetime(new Date());
//            one.setStartDatetime(sleep.getStartDatetime());
//            one.setEndDatetime(sleep.getEndDatetime());
            one.setData(sleep.getData());
            i = sleepMapper.updateByPrimaryKeySelective(one);
        }
        if (i > 0) {
            return JsonMap.of(true, "保存成功");
        } else {
            return JsonMap.of(false, "保存失败");
        }
    }

    @Override
    public JsonMap update(String sleepSid, Sleep sleep) {
        sleep.setSid(sleepSid);
        int i = sleepMapper.updateByPrimaryKeySelective(sleep);
        if (i > 0) {
            return JsonMap.of(true, "修改成功");
        } else {
            return JsonMap.of(false, "修改失败");
        }
    }

    @Override
    public JsonMap delete(String... sleepSids) {

        try {
            for (int i = 0; i < sleepSids.length; i++) {
                Sleep sleep = new Sleep();

                sleep.setSid(sleepSids[i]);

                sleepMapper.updateByPrimaryKeySelective(sleep);

            }
        } catch (Exception e) {
            return JsonMap.of(false, "删除失败");
        }
        return JsonMap.of(true, "删除成功");
    }

    @Override
    public List<Sleep> report(String accountSid, String deviceSid, Date startDate, Date endDate) {
        SleepExample sleepExample = new SleepExample();
        sleepExample.createCriteria().andAccountSidEqualTo(accountSid).andDeviceSidEqualTo(deviceSid).andStartDatetimeBetween(startDate, endDate);
        sleepExample.setOrderByClause(" start_datetime asc");
        List<Sleep> sleeps = sleepMapper.selectByExample(sleepExample);
        return sleeps;
    }
}