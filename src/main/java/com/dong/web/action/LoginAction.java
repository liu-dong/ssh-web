package com.dong.web.action;

import com.dong.constant.CommonConstant;
import com.dong.web.entity.Account;
import com.dong.web.model.LoginDTO;
import com.dong.web.model.UserDetail;
import com.dong.web.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.http.HttpSession;

/**
 * @author liudong 2024-05-14 16:52:28
 */
public class LoginAction extends ActionSupport {

    private LoginDTO loginDTO;
    private String username;
    private String password;


    private LoginService loginService;



    @Override
    public String execute() throws Exception {
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            System.out.println(username);
        }
        return super.execute();
    }

    public String login(HttpSession httpSession) {
        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
            UserDetail userDetail = loginService.login(username, password);
            httpSession.setAttribute(CommonConstant.SESSION_USER, userDetail);
            return "success";
        } else {
            return "error";
        }
    }

    public LoginDTO getLoginDTO() {
        return loginDTO;
    }

    public void setLoginDTO(LoginDTO loginDTO) {
        this.loginDTO = loginDTO;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
