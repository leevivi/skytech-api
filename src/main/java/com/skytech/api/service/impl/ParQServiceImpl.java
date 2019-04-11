package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.core.service.impl.GenericOneServiceImpl;
import com.skytech.api.mapper.ParQMapper;
import com.skytech.api.model.ParQ;
import com.skytech.api.model.ParQExample;
import com.skytech.api.service.ParQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 2019/4/10.
 */
@Service("parQService")
public class ParQServiceImpl extends GenericOneServiceImpl<ParQ,ParQExample,Integer> implements ParQService {

    @Autowired
    private ParQMapper parQMapper;
    @Override
    protected GenericOneMapper<ParQ, ParQExample, Integer> getGenericOneMapper() {
        return this.parQMapper;
    }


    @Override
    public JsonMap save(HttpSession session,ParQ parQ) throws Exception {
        Object accountSidObj = session.getAttribute("accountSid");
        String accountSid = accountSidObj.toString();
        ParQExample parQExample = new ParQExample();
        parQExample.createCriteria().andAccountSidEqualTo(accountSid);
        List<ParQ> parQS = parQMapper.selectByExample(parQExample);
        if(!parQS.isEmpty()){
            //修改数据
            parQ.setId(parQS.get(0).getId());
            int i = parQMapper.updateByPrimaryKeySelective(parQ);
            if (i > 0) {
                return JsonMap.of(true, "保存成功");
            } else {
                return JsonMap.of(false, "保存失败");
            }
        }
        else {
            //新增数据
            parQ.setCreatedTime(new Date());
            parQ.setAccountSid(accountSid);
            int i = parQMapper.insertSelective(parQ);
            if (i > 0) {
                return JsonMap.of(true, "保存成功");
            } else {
                return JsonMap.of(false, "保存失败");
            }
        }


    }

    @Override
    public JsonMap update(int dataId, ParQ parQ) {
        parQ.setId(dataId);
        int i = parQMapper.updateByPrimaryKeySelective(parQ);
        if (i > 0) {
            return JsonMap.of(true, "修改成功");
        } else {
            return JsonMap.of(false, "修改失败");
        }
    }
}
