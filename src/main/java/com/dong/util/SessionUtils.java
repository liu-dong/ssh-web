package com.dong.util;

import com.dong.constant.CommonConstant;
import com.dong.web.model.UserDetail;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * 会话工具类
 *
 * @author liudong 2024-05-23 11:24:28
 */
public class SessionUtils {

    /**
     * 获取用户信息
     *
     * @return
     */
    public static UserDetail getUserDetail() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        return (UserDetail) session.getAttribute(CommonConstant.SESSION_USER);
    }
}
