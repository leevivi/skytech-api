package com.skytech.api.controller;

import com.skytech.api.core.JsonMap;
import com.skytech.api.mapper.ParQMapper;
import com.skytech.api.model.ParQ;
import com.skytech.api.model.ParQExample;
import com.skytech.api.model.PhysiologicalIndex;
import com.skytech.api.service.ParQService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 1 on 2019/4/10.
 */
@RestController
public class ParQController {

    @Autowired
    private ParQService parQService;
    @Autowired
    private ParQMapper parQMapper;


    @ApiOperation(value = "详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int")
    })
    @GetMapping(value = "/userParQ/getUserParQ")
    public JsonMap getUserParQ(HttpSession session) {
        Object accountSidObj = session.getAttribute("accountSid");
        String accountSid = accountSidObj.toString();
        ParQExample parQExample = new ParQExample();
        parQExample.createCriteria().andAccountSidEqualTo(accountSid);
        List<ParQ> parQS = parQMapper.selectByExample(parQExample);
        if (!parQS.isEmpty()){
            return JsonMap.of(true, "", parQS.get(0));
        }
        else {
            ParQ parQ = new ParQ();
            return JsonMap.of(true, "", parQ);
        }

    }
    @ApiOperation(value = "新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ParQ", value = "", required = true, dataType = "ParQ"),

    })
    @PostMapping(value = "/userParQ/save")
    public JsonMap save(HttpSession session,@RequestBody ParQ parQ) throws Exception {

        return parQService.save(session,parQ);

    }

    @ApiOperation(value = "修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dataId", value = "dataId", required = true, dataType = "String"),
            @ApiImplicitParam(name = "ParQ", value = "", required = true, dataType = "ParQ")
    })
    @PostMapping(value = "/userParQ/update")
    public JsonMap update(int dataId, ParQ parQ) {

        return parQService.update(dataId, parQ);

    }
}
