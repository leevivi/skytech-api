package com.skytech.api.controller;

import com.owthree.core.JsonMap;
import com.owthree.core.Pagination;
import com.skytech.api.model.Account;
import com.skytech.api.service.AccountService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 剑神卓凌昭
 * @date 2018-11-06 14:36:15
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/account/listForPage")
    public Map<String, Object> listForPage(int page, int limit) {

        Pagination<Account> pagination = accountService.findForPage(page, limit);

        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("msg", "成功");
        data.put("count", pagination.getTotalRowNumber());
        data.put("data", pagination.getDataList());

        return data;
    }

    @ApiOperation(value = "详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @GetMapping(value = "/account/listBySid")
    public JsonMap listBySid(String sid) {
        Account account = accountService.selectByPrimaryKey(sid);

        return JsonMap.of(true, "", account);
    }

    @ApiOperation(value = "新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "", required = true, dataType = "Account")
    })
    @PostMapping(value = "/account/save")
    public JsonMap save(Account account) {

        return accountService.save(account);

    }

    @ApiOperation(value = "修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dataId", value = "dataId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "account", value = "", required = true, dataType = "Account")
    })
    @PostMapping(value = "/account/update")
    public JsonMap update(String dataId, Account account) {

        return accountService.update(dataId, account);

    }

    @ApiOperation(value = "删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sid", value = "sid", required = true, dataType = "String")
    })
    @PostMapping(value = "/account/delete")
    public JsonMap delete(String sid) {

        return accountService.delete(sid);

    }

    /**
     * @param session
     * @param email
     * @param password
     * @param firstName
     * @param lastName
     * @return
     */
    @ApiOperation(value = "注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "email", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "password", required = true, dataType = "String"),
            @ApiImplicitParam(name = "firstName", value = "firstName", required = true, dataType = "String"),
            @ApiImplicitParam(name = "lastName", value = "lastName", required = true, dataType = "String")
    })
    @PostMapping(value = "/account/register")
    public Map<String, Object> register(HttpSession session, String email, String password, String firstName, String lastName) {

        Map<String, Object> map = accountService.register(email, password, firstName, lastName);
        String code = map.get("code").toString();
        if (StringUtils.equals(code, "2000")) {
            session.setAttribute("accountSid", map.get("accountSid").toString());
        }
        return map;
    }

    /**
     * @param session
     * @param email
     * @param password
     * @return
     */
    @ApiOperation(value = "登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "email", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "password", required = true, dataType = "String")
    })
    @PostMapping(value = "/account/login")
    public Map<String, Object> login(HttpSession session, String email, String password) {

        Map<String, Object> data = accountService.login(email, password);

        if (data != null) {
            session.setAttribute("accountSid", ((Account) data.get("account")).getSid());
            return JsonMap.of(true, "登陆成功", data);
        } else {
            return JsonMap.of(false, "邮箱或者密码错误");
        }
    }

    @PostMapping(value = "/account/saveProfile")
    public JsonMap saveProfile(HttpSession session, Account account, @RequestParam(value = "picFile", required = false) MultipartFile picFile) {

        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();

        return accountService.saveProfile(accountSid, account, picFile);

    }

    @PostMapping(value = "/account/saveAvatar")
    public JsonMap saveProfile(HttpSession session, @RequestParam(value = "picFile", required = false) MultipartFile picFile) {

        Object accountSidObj = session.getAttribute("accountSid");

        String accountSid = accountSidObj.toString();

        return accountService.saveAvatar(accountSid, picFile);

    }
}
