package com.skytech.api.config;

import com.alibaba.fastjson.JSON;
import com.skytech.api.core.utils.GsonUtils;
import com.skytech.api.model.Account;
import com.skytech.api.service.AccountService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
    private final Logger LOGGER = LoggerFactory.getLogger(AuthInterceptor.class);

    @Autowired
    private AccountService accountService;

    private final static String SESSION_KEY_PREFIX = "session:";

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        LOGGER.info("session={}", session.getId());

        String uri = request.getRequestURI();

        LOGGER.info("----------begin AuthInterceptor-------------");
        LOGGER.info("recordTime={}" + new Date());
        LOGGER.info("uri={}", uri);

        long startTime = System.currentTimeMillis();

        request.setAttribute("startTime", startTime);
        String method = request.getMethod();
        String url = request.getRequestURL().toString();
        String params = GsonUtils.ModuleTojosn(request.getParameterMap());
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                LOGGER.info("{}:{}:domain={}:path={}:toString={}"
                        + cookie.getName() + " ; " + cookie.getValue() + " ; " + cookie.getDomain() + " ; "
                        + cookie.getPath() + " ; " + cookie.toString());
            }
        }
        LOGGER.info("url={}:uri={}:method={}:params={}" + url + " ; " + uri + " ; " + method + " ; "+  params);
        LOGGER.info("-----------end AuthInterceptor------------");

        if (StringUtils.contains(uri, "account/register") || StringUtils.contains(uri, "account/login")) {
            return true;
        }

        if (session != null) {
            Object accountSidObj = session.getAttribute("accountSid");
            LOGGER.info("accountSidObj={}" + accountSidObj);
            if (accountSidObj == null) {
                response.setContentType("application/json");
                ServletOutputStream os = response.getOutputStream();
                @SuppressWarnings("Convert2Diamond") Map<String, String> map = new HashMap<String, String>();
                map.put("code", "5001");
                map.put("message", "用户未登录");

                IOUtils.write(JSON.toJSONString(map), os);
                os.close();
                return false;
            } else {
                LOGGER.info("accountIdObj={}", accountSidObj);
                if (accountSidObj != null) {
                    Account account = accountService.selectByPrimaryKey((String) accountSidObj);

                    if (null == account) {
                        LOGGER.error("账号不存在");
                        response.setContentType("application/json");
                        ServletOutputStream os = response.getOutputStream();
                        Map<String, String> map = new HashMap<>();
                        map.put("code", "5001");
                        map.put("message", "用户未登录");
                        IOUtils.write(JSON.toJSONString(map), os);
                        os.close();
                        return false;
                    }
                }
            }
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Object startTimeObj = request.getAttribute("startTime");
        if (null != startTimeObj) {
            long startTime = (Long) startTimeObj;
            long endTime = System.currentTimeMillis();
        }

        super.postHandle(request, response, handler, modelAndView);
    }

}
