package com.skytech.api.controller;

import com.alibaba.fastjson.JSON;
import com.skytech.api.core.JsonMap;
import com.skytech.api.core.utils.CheckUtil;
import com.skytech.api.core.utils.JsonXMLUtil;
import com.skytech.api.mapper.PhysiologicalIndexMapper;
import com.skytech.api.mapper.UserDataMapper;
import com.skytech.api.model.*;
import com.skytech.api.service.UserDataService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by 1 on 2019/4/10.
 */
@RestController
public class UserDataController {
    private final Logger LOGGER = LoggerFactory.getLogger(UserDataController.class);

    @Autowired
    private UserDataService userDataService;
    @Autowired
    private PhysiologicalIndexMapper physiologicalIndexMapper;
    @Autowired
    private UserDataMapper userDataMapper;


    @ApiOperation(value = "详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int")
    })
    @GetMapping(value = "/userData/getUserData")
    public JsonMap getUserData(HttpSession session) {
        Object accountSidObj = session.getAttribute("accountSid");
        String accountSid = accountSidObj.toString();
        List<UserDataForNull> list = new ArrayList<>();
        UserDataExample userDataExample = new UserDataExample();
        userDataExample.createCriteria().andAccountSidEqualTo(accountSid);
        List<UserData> userDataList = userDataMapper.selectByExample(userDataExample);
        //基础生理数据模板表
        PhysiologicalIndexExample physiologicalIndexExample = new PhysiologicalIndexExample();
        List<PhysiologicalIndex> physiologicalIndexList = physiologicalIndexMapper.selectByExample(physiologicalIndexExample);
        //存在用户生理数据
        if (!userDataList.isEmpty()){
            //用户生理数据不齐全，需要补全用户剩余生理数据
            if(userDataList.size()<physiologicalIndexList.size()){
                //生成空生理数据
                for(int i=0;i<physiologicalIndexList.size();i++){
                    addNullUserData(list, physiologicalIndexList, i);
                }
                /*int[] existIds = new int[physiologicalIndexList.size()];*/
                //查找出已存在生理数据，覆盖对应数据
                for(int j = 0;j<userDataList.size();j++){
                    for (UserData ud :userDataList) {
                        for(int k = 0;k<physiologicalIndexList.size();k++){
                            if(ud.getUserdataId()==physiologicalIndexList.get(k).getId()){
                                list.get(ud.getUserdataId()-1).setDataActual(ud.getDataActual());
                                list.get(ud.getUserdataId()-1).setDataGoal(ud.getDataGoal());
                            }
                        }
                    }
                }
            }else {
                //用户生理数据齐全，不用补全默认数据
                for (UserData ud :userDataList) {
                    addUserData(list, ud);
                }
            }
            return JsonMap.of(true, "", list);
        }
        //第一次进入，不存在用户生理数据
        else {
            for(int x=0;x<physiologicalIndexList.size();x++){
                addNullUserData(list, physiologicalIndexList, x);
            }
            return JsonMap.of(true, "",list);
        }

    }

    public void addNullUserData(List<UserDataForNull> list, List<PhysiologicalIndex> physiologicalIndexList, int i) {
        UserDataForNull userDataForNull = new UserDataForNull();
        userDataForNull.setDataSortNum(physiologicalIndexList.get(i).getSortNum());
        userDataForNull.setUserdataId(physiologicalIndexList.get(i).getId());
        userDataForNull.setDataName(physiologicalIndexList.get(i).getTagName());
        userDataForNull.setDataActual(new BigDecimal(0));
        userDataForNull.setDataGoal(new BigDecimal(0));
        userDataForNull.setDataUnit(physiologicalIndexList.get(i).getDataUnit());
        userDataForNull.setUpToStandard(0);
        list.add(userDataForNull);
    }

    /**
     *
     * @param list
     * @param ud
     */
    public void addUserData(List<UserDataForNull> list, UserData ud) {
        UserDataForNull userDataForNull = new UserDataForNull();
        userDataForNull.setDataSortNum(ud.getUserdataId());
        userDataForNull.setUserdataId(ud.getId());
        PhysiologicalIndex physiologicalIndex = physiologicalIndexMapper.selectByPrimaryKey(ud.getUserdataId());
        userDataForNull.setDataName(physiologicalIndex.getTagName());
        userDataForNull.setDataActual(ud.getDataActual());
        userDataForNull.setDataGoal(ud.getDataGoal());
        userDataForNull.setDataUnit(physiologicalIndex.getDataUnit());
        userDataForNull.setUpToStandard(ud.getUpToStandard());
        list.add(userDataForNull);
    }

    @ApiOperation(value = "新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "UserData", value = "", required = true, dataType = "UserData"),

    })
    @PostMapping(value = "/userData/save")
    public JsonMap save(HttpSession session,@RequestBody List<UserData> userDataForList) throws Exception {
        System.out.println(userDataForList);

        return userDataService.save(session,userDataForList);

    }

    @ApiOperation(value = "修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dataId", value = "dataId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "report", value = "", required = true, dataType = "Report")
    })
    @PostMapping(value = "/userData/update")
    public JsonMap update(int dataId, UserData userData) {

        return userDataService.update(dataId, userData);

    }

    @ApiOperation(value = "删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "邀约id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "report", value = "", required = true, dataType = "Report")
    })
    @PostMapping(value = "/report/delete")
    public JsonMap delete(int dataId) {

        return userDataService.delete(dataId);

    }


}
