package com.skytech.api.service.impl;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.mapper.HeartRateMapper;
import com.skytech.api.model.Account;
import com.skytech.api.model.HeartRate;
import com.skytech.api.model.HeartRateExample;
import com.skytech.api.model.base.BaseHeartRateExample;
import com.skytech.api.service.HeartRateService;
import com.owthree.core.service.impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("heartRateService")
public class HeartRateServiceImpl extends GenericServiceImpl<HeartRate, HeartRateExample, String> implements HeartRateService {

    @Autowired
    private HeartRateMapper heartRateMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    protected HeartRateMapper getGenericMapper() {
        return this.heartRateMapper;
    }

    @Override
    public Pagination<HeartRate> findForPage(int page, int limit) {
        HeartRateExample heartRateExample = new HeartRateExample();
        BaseHeartRateExample.Criteria criteria = heartRateExample.createCriteria();

        Pagination<HeartRate> pagination = this.queryByPage(heartRateExample, (page - 1) * limit, limit, "created_datetime desc");

        return pagination;
    }

    @Override
    public JsonMap save(HeartRate heartRate) {
        Account account = accountMapper.selectByPrimaryKey(heartRate.getAccountSid());
        heartRate.setAccountName(account.getFirstName() + account.getLastName());

        HeartRateExample heartRateExample = new HeartRateExample();

        List<HeartRate> heartRates = heartRateMapper.selectByExample(heartRateExample);

        heartRate.setSid(UUID.randomUUID().toString().replaceAll("-", ""));
        heartRate.setCreatedDatetime(new Date());
        int i = heartRateMapper.insertSelective(heartRate);
        if (i > 0) {
            return JsonMap.of(true, "保存成功");
        } else {
            return JsonMap.of(false, "保存失败");
        }
    }

    @Override
    public JsonMap update(String heartRateSid, HeartRate heartRate) {
        heartRate.setSid(heartRateSid);
        int i = heartRateMapper.updateByPrimaryKeySelective(heartRate);
        if (i > 0) {
            return JsonMap.of(true, "修改成功");
        } else {
            return JsonMap.of(false, "修改失败");
        }
    }

    @Override
    public JsonMap delete(String... heartRateSids) {

        try {
            for (int i = 0; i < heartRateSids.length; i++) {
                HeartRate heartRate = new HeartRate();

                heartRate.setSid(heartRateSids[i]);

                heartRateMapper.updateByPrimaryKeySelective(heartRate);

            }
        } catch (Exception e) {
            return JsonMap.of(false, "删除失败");
        }
        return JsonMap.of(true, "删除成功");
    }
}