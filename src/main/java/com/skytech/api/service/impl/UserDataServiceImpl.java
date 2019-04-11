package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.core.service.impl.GenericOneServiceImpl;
import com.skytech.api.mapper.PhysiologicalIndexMapper;
import com.skytech.api.mapper.UserDataMapper;
import com.skytech.api.model.PhysiologicalIndex;
import com.skytech.api.model.PhysiologicalIndexExample;
import com.skytech.api.model.UserData;
import com.skytech.api.model.UserDataExample;
import com.skytech.api.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
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
    public JsonMap save(HttpSession session,UserData userData) {
        Object accountSidObj = session.getAttribute("accountSid");
        String accountSid = accountSidObj.toString();
        UserDataExample userDataExample = new UserDataExample();
        userDataExample.createCriteria().andUserdataIdEqualTo(userData.getUserdataId());
        List<UserData> userDataList = userDataMapper.selectByExample(userDataExample);
        if(!userDataList.isEmpty()){
            //修改数据
            userData.setId(userDataList.get(0).getId());
            int i = userDataMapper.updateByPrimaryKeySelective(userData);
            if (i > 0) {
                return JsonMap.of(true, "保存成功");
            } else {
                return JsonMap.of(false, "保存失败");
            }
        }
        else {
            //新增数据
//            userData.setUserdataId(dataId);
            userData.setAccountSid(accountSid);
            userData.setCreatedTime(new Date());
            int j = userDataMapper.insertSelective(userData);
            if (j > 0) {
                return JsonMap.of(true, "保存成功");
            } else {
                return JsonMap.of(false, "保存失败");
            }
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
