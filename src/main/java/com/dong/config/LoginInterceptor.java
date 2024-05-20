package com.dong.config;

import com.dong.constant.CommonConstant;
import com.opensymphony.xwork2.ActionContext;
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
        final ActionContext context = invocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);

        String actionName = invocation.getProxy().getActionName(); // 获取当前请求的Action名称

        if ("login".equals(actionName)) { // 假设登录操作的Action名称是loginAction
            // 如果当前执行的是登录操作，则不进行拦截，直接执行
            return invocation.invoke();
        } else {
            // 非登录操作，检查用户是否已经登录
            if (request.getSession().getAttribute(CommonConstant.SESSION_USER) == null) {
                // 用户未登录，返回"login"字符串
                return "login";
            } else {
                // 用户已登录，继续执行后续操作
                return invocation.invoke();
            }
        }
    }

    @Override
    public void destroy() {
    }
}
