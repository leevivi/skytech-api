package com.skytech.api.service.impl;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.core.mapper.GenericOneMapper;
import com.skytech.api.core.service.impl.GenericOneServiceImpl;
import com.skytech.api.mapper.AccountMapper;
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
    @Autowired
    private AccountMapper accountMapper;

    @Override
    protected GenericOneMapper<UserData, UserDataExample, Integer> getGenericOneMapper() {
        return this.userDataMapper;
    }


    @Override
    public JsonMap save(HttpSession session,List<UserData> userDataForList) {
        Object accountSidObj = session.getAttribute("accountSid");
        String accountSid = accountSidObj.toString();
        Account account = accountMapper.selectByPrimaryKey(accountSid);
        int i = 0;
        int j = 0;
        for (UserData userData :userDataForList) {
            UserDataExample userDataExample = new UserDataExample();
            userDataExample.createCriteria().andUserdataIdEqualTo(userData.getUserdataId()).andAccountSidEqualTo(accountSid);
            List<UserData> userDataList1 = userDataMapper.selectByExample(userDataExample);
            if(!userDataList1.isEmpty()){
                //修改数据
                UserData one = new UserData();
                    one.setAccountSid(accountSid);
                    one.setId(userDataList1.get(0).getId());
                    //先判断用户目标是否改动
                    if(userData.getDataGoal().equals(userDataList1.get(0).getDataGoal())){
                        //用户目标没有改动
                        if(userData.getDataGoal().subtract(userData.getDataActual()).doubleValue()>0){
                            one.setUpToStandard(0);
                        }
                        if(userData.getDataGoal().subtract(userData.getDataActual()).doubleValue()<=0){
                            one.setUpToStandard(1);
                        }
                    }
                    else {
                        //用户目标改动
                        if(userData.getDataActual().equals(userDataList1.get(0).getDataActual())){
                            //用户实际值没有改动
                            if(userData.getDataGoal().subtract(userData.getDataActual()).doubleValue()>0){
                                one.setUpToStandard(0);
                            }
                            if(userData.getDataGoal().subtract(userData.getDataActual()).doubleValue()<=0){
                                one.setUpToStandard(1);
                            }
                        }else {
                            //用户实际值改动
                            if(userData.getDataGoal().subtract(userData.getDataActual()).doubleValue()>0){
                                one.setUpToStandard(1);
                            }
                            if(userData.getDataGoal().subtract(userData.getDataActual()).doubleValue()<=0){
                                one.setUpToStandard(0);
                            }
                        }

                    }
                UserData ud = userDataList1.get(0);
                boolean a = ud.getDataActual().compareTo(BigDecimal.ZERO) == 0;
                boolean b = ud.getDataGoal().compareTo(BigDecimal.ZERO) == 0;
                if(a && b){
                    one.setUpToStandard(0);
                }
                    one.setDataActual(userData.getDataActual());
                    one.setDataGoal(userData.getDataGoal());
                    one.setUpdatedTime(new Date());
                    i = userDataMapper.updateByPrimaryKeySelective(one);
            }
            else {
                //新增数据
                userData.setAccountSid(accountSid);
                userData.setAppuser(account.getEmail());
                userData.setUpToStandard(0);
                userData.setCreatedTime(new Date());
                j = userDataMapper.insertSelective(userData);

            }
        }
        if (i > 0 || j > 0) {
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
