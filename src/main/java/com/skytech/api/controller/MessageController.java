package com.skytech.api.controller;

import com.skytech.api.core.JsonMap;
import com.skytech.api.core.Pagination;
import com.skytech.api.mapper.AccountMapper;
import com.skytech.api.mapper.TMemberMapper;
import com.skytech.api.model.*;
import com.skytech.api.service.MessageService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiWei on 2019/4/7.
 */
@RestController
public class MessageController {
    Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
    @Autowired
    private MessageService messageService;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private TMemberMapper tMemberMapper;

    @ApiOperation(value="列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/message/listForPage")
    public Map<String, Object> listForPage(int page, int limit) {
        Pagination<TMessage> pagination = messageService.findForPage(page, limit);

        Map<String, Object> data = new HashMap<>();
        data.put("code", "2000");
        data.put("message", "成功");
        data.put("count", pagination.getTotalRowNumber());
        data.put("data", pagination.getDataList());

        return data;
    }

    @ApiOperation(value = "我的消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "messageType", value = "消息类型", required = true, dataType = "int")
    })
    @PostMapping(value = "/message/myMessage")
    public JsonMap myMessage(HttpSession session, int messageType) {
        Map<String, Object> data = new HashMap<>();
        List<MyMessage> list = new ArrayList<>();
        List<MyMessage> MyMessageList = new ArrayList<>();
        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();
        Map<String, Object> memberInfoData = new HashMap<>();
        memberInfoData = checkMembers(memberInfoData, accountSid);
        List<MemberInfo> memberList = new ArrayList<>();
        int memberId = 0;
        try {
            memberList = (List<MemberInfo>) memberInfoData.get("memberInfoList");
            for (MemberInfo memberInfo :memberList) {
                memberId = memberInfo.getMemberId();
                data = messageService.myMessage(memberId, messageType);
                if(data.size()!=0){
                    MyMessageList = (List<MyMessage>) data.get("MyMessage");
                    list.addAll(MyMessageList);
                }
            }
        }catch (Exception e){
            return JsonMap.of(true, "",new ArrayList<>());
        }

        return JsonMap.of(true, "",list);

    }

    public Map<String,Object> checkMembers(Map<String, Object> data, String accountSid) {
        List<Object> memberInfoList = new ArrayList<>();
        Account account = accountMapper.selectByPrimaryKey(accountSid);
        TMemberExample tMemberExample = new TMemberExample();
        tMemberExample.createCriteria().andAppuserEqualTo(account.getEmail());
        List<TMember> tMembers = tMemberMapper.selectByExample(tMemberExample);
        if(tMembers.isEmpty()||tMembers.get(0).getCompanyid()==null||tMembers.get(0).getStoresid()==null){
            List<TCourse> list = new ArrayList<>();
            data.put("data", list);
            return data;
        }
        for (TMember tMember :tMembers) {
            MemberInfo memberInfo = new MemberInfo();
            memberInfo.setMemberId(tMember.getId());
            memberInfo.setCompanyId(tMember.getCompanyid());
            memberInfo.setStoresId(tMember.getStoresid());
            memberInfoList.add(memberInfo);

        }
        data.put("memberInfoList",memberInfoList);
        return data;
    }

}
