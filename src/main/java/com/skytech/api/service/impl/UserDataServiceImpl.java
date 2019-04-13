package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.core.service.impl.GenericOneServiceImpl;
import com.skytech.api.mapper.PhysiologicalIndexMapper;
import com.skytech.api.mapper.UserDataMapper;
import com.skytech.api.model.*;
import com.skytech.api.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 2019/4/10.
 */
@Service("userDataService")
public class UserDataServiceImpl extends GenericOneServiceImpl<UserData,UserDataExample,Integer> implements UserDataService {

    @Autowired
    private UserDataMapper userDataMapper;

    @Override
    protected GenericOneMapper<UserData, UserDataExample, Integer> getGenericOneMapper() {
        return this.userDataMapper;
    }


    @Override
    public JsonMap save(HttpSession session,List<UserData> userDataForList) {
        Object accountSidObj = session.getAttribute("accountSid");
        String accountSid = accountSidObj.toString();
        int i = 0;
        int j = 0;
        for (UserData userData :userDataForList) {
            UserDataExample userDataExample = new UserDataExample();
            userDataExample.createCriteria().andUserdataIdEqualTo(userData.getUserdataId());
            List<UserData> userDataList1 = userDataMapper.selectByExample(userDataExample);
            if(!userDataList1.isEmpty()){
                //修改数据
                for (UserData ud : userDataList1) {
                    ud.setAccountSid(accountSid);
                    ud.setId(userDataList1.get(0).getId());
                    if(ud.getDataGoal().subtract(ud.getDataActual()).doubleValue()>0){
                        ud.setUpToStandard(1);
                    }
                    if(ud.getDataGoal().subtract(ud.getDataActual()).doubleValue()<=0){
                        ud.setUpToStandard(0);
                    }
                    ud.setUpdatedTime(new Date());
                    i = userDataMapper.updateByPrimaryKeySelective(ud);
                }
            }
            else {
                //新增数据
                userData.setAccountSid(accountSid);
                userData.setCreatedTime(new Date());
                j = userDataMapper.insertSelective(userData);

            }
        }
        if (i > 0 && j > 0) {
            return JsonMap.of(true, "保存成功");
        } else {
            return JsonMap.of(false, "保存失败");
        }

    }

    @Override
    public JsonMap delete(Integer... dataIds) {
        return null;
    }

    @Override
    public JsonMap update(int dataId, UserData userData) {

        return null;
    }
}
