package com.dong.config;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liudong 2024-05-16 17:50:00
 */
public class LoginInterceptor implements Interceptor {
    @Override
    public void init() {
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getSession().getAttribute("user") == null) {
            // 用户未登录，返回"login"字符串
            return "login";
        } else {
            // 用户已登录，继续执行后续操作
            return invocation.invoke();
        }
    }

    @Override
    public void destroy() {
    }
}
